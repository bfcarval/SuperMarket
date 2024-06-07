package com.supermarket.api.config;

import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.database.dao.ShoppingDAO;
import com.supermarket.api.feign.MockClient;
import com.supermarket.api.model.dto.ShoppingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

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

        products.forEach(p -> productDAO.createProduct(p));

        clients.forEach(c -> {
                    final var shopping = new ArrayList<ShoppingDTO>();

                    c.getShopping().forEach(sh ->
                            shopping.add(shoppingDAO.createShopping(sh, c))
                    );

                    clientDAO.createClient(c, shopping);
                }
        );
    }

}
