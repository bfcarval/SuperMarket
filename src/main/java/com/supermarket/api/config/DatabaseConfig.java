package com.supermarket.api.config;

import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.database.dao.ShoppingDAO;
import com.supermarket.api.feign.MockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.supermarket.api.mapper.ClientMapper.clientFeignResponseToDTO;
import static com.supermarket.api.mapper.ProductMapper.productFeignResponseToDTO;
import static com.supermarket.api.mapper.ShoppingMapper.shoppingFeignResponseToDTO;

@Configuration
public class DatabaseConfig {

    @Autowired
    private MockClient mockClient;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Bean
    public void loadDatabase() {
        final var clients = mockClient.getClients();
        final var products = mockClient.getProducts();

        products.forEach(p -> productDAO.create(productFeignResponseToDTO(p)));

        clients.forEach(c -> {
                    var client = clientFeignResponseToDTO(c);

                    c.getShopping().forEach(sh -> shoppingDAO.create(shoppingFeignResponseToDTO(sh), client));

                    clientDAO.create(client);
                }
        );
    }
}