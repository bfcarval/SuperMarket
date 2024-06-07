package com.supermarket.api.service;

import com.supermarket.api.SuperMarketApi;
import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.database.dao.ShoppingDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static com.supermarket.api.service.factory.ClientFactory.makeClients;
import static com.supermarket.api.service.factory.ProductFactory.makeProducts;
import static com.supermarket.api.service.factory.ShoppingFactory.makeShoppings;

@SpringBootTest(classes = SuperMarketApi.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ProductDAO productDAO;

    @Mock
    private ClientDAO clientDAO;

    @Mock
    private ShoppingDAO shoppingDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindThreeTopClients() {
        Mockito.when(productDAO.findAll()).thenReturn(
                makeProducts()
        );

        Mockito.when(clientDAO.findAll()).thenReturn(
                makeClients()
        );

        Mockito.when(shoppingDAO.findAll()).thenReturn(
                makeShoppings()


        );

        final var topClients = clientService.findTopThreeClients();

        Assertions.assertNotNull(topClients);
        Assertions.assertEquals(3, topClients.size());
    }

    @Test
    public void shouldGetBestWineRecommendation() {
        Mockito.when(productDAO.findAll()).thenReturn(
                makeProducts()
        );

        Mockito.when(clientDAO.findAll()).thenReturn(
                makeClients()
        );

        Mockito.when(shoppingDAO.findAll()).thenReturn(
                makeShoppings()


        );

        final var wineRecommendation = clientService.getWineRecommendation();

        Assertions.assertNotNull(wineRecommendation);
    }
}