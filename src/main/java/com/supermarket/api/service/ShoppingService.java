package com.supermarket.api.service;

import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.exception.ProductNotFoundException;
import com.supermarket.api.mapper.ProductMapper;
import com.supermarket.api.model.dto.ClientShoppingDTO;
import com.supermarket.api.model.dto.TotalShoppingDTO;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.supermarket.api.util.TotalShoppingUtil.generateTotalShopping;

@Service
public class ShoppingService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ClientDAO clientDAO;

    public List<TotalShoppingDTO> findAll() {
        final var products = productDAO.findAll().stream().map(ProductMapper::productEntityToDTO).collect(Collectors.toList());
        final var clients = clientDAO.findAll();
        final var totalShoppingList = generateTotalShopping(clients, products);

        totalShoppingList.forEach(list -> list.getClientShoppingDTOS().sort(Comparator.comparing(ClientShoppingDTO::getTotal)));
        totalShoppingList.sort(Comparator.comparing(TotalShoppingDTO::getClientName));

        return totalShoppingList;
    }

    public TotalShoppingDTO findBigPurchasedYear(final Long year) {
        final var products = productDAO.findByPurchasedYear(year).stream().map(ProductMapper::productEntityToDTO).collect(Collectors.toList());

        if (products.isEmpty()) throw new ProductNotFoundException("Nao existem produtos comprados para este ano");

        final var clients = clientDAO.findAll();
        final var totalShoppingList = generateTotalShopping(clients, products);

        var bigPurchasedYearList = totalShoppingList.stream().map( tp -> tp.getClientShoppingDTOS()
                .stream().map(ClientShoppingDTO::getTotal).max(BigDecimal::compareTo).orElse(BigDecimal.ZERO)).collect(Collectors.toList()
        );

        bigPurchasedYearList = bigPurchasedYearList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        final var bigPurchasedYear = bigPurchasedYearList.stream().findFirst().get();

        var totalShoppingListFiltered = totalShoppingList.stream().filter(cl -> cl.getClientShoppingDTOS()
                        .stream().anyMatch(cls -> cls.getTotal().compareTo(bigPurchasedYear) == 0))
                .collect(Collectors.toList());

        totalShoppingListFiltered.stream().findFirst().get().getClientShoppingDTOS()
                .removeIf(pp -> pp.getTotal().compareTo(bigPurchasedYear) != 0);

        return totalShoppingListFiltered.stream().findFirst().get();
    }
}
