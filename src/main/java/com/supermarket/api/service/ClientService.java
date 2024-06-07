package com.supermarket.api.service;

import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.mapper.ProductMapper;
import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.model.dto.TopClientDTO;
import com.supermarket.api.util.Triple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.supermarket.api.util.TotalShoppingUtil.generateTotalShopping;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ProductDAO productDAO;

    public List<TopClientDTO> findTopThreeClients() {
        final var products = productDAO.findAll().stream().map(ProductMapper::productEntityToDTO).collect(Collectors.toList());
        final var clients = clientDAO.findAll();
        final var totalShoppingList = generateTotalShopping(clients, products);
        final ArrayList<Triple<Object, Object, Object>> tripleList = new ArrayList<>();

        totalShoppingList.forEach(ts -> {
            final Triple<Object, Object, Object> triple = Triple.builder()
                    .first(ts.getClientName())
                    .build();

            ts.getClientShoppingDTOS().forEach( cls -> {
                if (ObjectUtils.isEmpty(triple.getSecond())) {
                    triple.setSecond(cls.getQuantity());
                } else {
                    triple.setSecond((Long) triple.getSecond() + cls.getQuantity());
                }

                if (ObjectUtils.isEmpty(triple.getThird())) {
                    triple.setThird(cls.getTotal());
                } else {
                    triple.setThird(new BigDecimal(triple.getThird().toString()).add(cls.getTotal()));
                }
            });

            tripleList.add(triple);
        });

        tripleList.sort(Comparator.comparing(tr -> (Long) tr.getSecond()));
        Collections.reverse(tripleList);
        tripleList.subList(3, tripleList.size()).clear();

        return tripleList.stream().map( t -> {
            return TopClientDTO.builder()
                    .name(t.getFirst().toString())
                    .quantity((Long) t.getSecond())
                    .total(new BigDecimal(t.getThird().toString()))
                    .build();
        }).collect(Collectors.toList());
    }

    public List<ProductDTO> getWineRecommendation() {
        final var products = productDAO.findAll().stream().map(ProductMapper::productEntityToDTO).collect(Collectors.toList());
        final var clients = clientDAO.findAll();
        final var totalShoppingList = generateTotalShopping(clients, products);
        final HashMap<Long, Long> wineMap = new HashMap<>();

        totalShoppingList.forEach( ts -> ts.getClientShoppingDTOS().forEach( cls -> {
            if (!wineMap.containsKey(cls.getProduct().getProductId())) {
                wineMap.put(cls.getProduct().getProductId(), cls.getQuantity());
            } else {
                wineMap.put(cls.getProduct().getProductId(), wineMap.get(cls.getProduct().getProductId()) + cls.getQuantity());
            }
        }));

        final var wineListFiltered = wineMap.entrySet().stream().filter(
                longLongEntry -> Objects.equals(longLongEntry.getValue(), wineMap.values().stream()
                        .max(Comparator.naturalOrder()).get())).map(Map.Entry::getKey).collect(Collectors.toList());

        return products.stream().filter( pr ->
                wineListFiltered.stream().anyMatch( wl -> wl.equals(pr.getProductId()))).collect(Collectors.toList());
    }
}