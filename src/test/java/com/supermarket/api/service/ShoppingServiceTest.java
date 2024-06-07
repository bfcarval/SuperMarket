package com.supermarket.api.service;

import com.supermarket.api.SuperMarketApi;
import com.supermarket.api.database.dao.ClientDAO;
import com.supermarket.api.database.dao.ProductDAO;
import com.supermarket.api.database.dao.ShoppingDAO;
import com.supermarket.api.exception.ProductNotFoundException;
import java.math.BigDecimal;
import java.util.Collections;
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
public class ShoppingServiceTest {

    @InjectMocks
    private ShoppingService shoppingService;

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
    public void shouldFindAllPurchases() {
        Mockito.when(productDAO.findAll()).thenReturn(
                makeProducts()
        );

        Mockito.when(clientDAO.findAll()).thenReturn(
                makeClients()
        );

        Mockito.when(shoppingDAO.findAll()).thenReturn(
                makeShoppings()
        );

        final var allPurchases = shoppingService.findAll();

        Assertions.assertNotNull(allPurchases);
        Assertions.assertEquals(3, allPurchases.size());
    }

    @Test
    public void shouldFindBigPurchasedYear() {
        Mockito.when(productDAO.findByPurchasedYear(Mockito.any())).thenReturn(
                Collections.singletonList(makeProducts().get(0))
        );

        Mockito.when(clientDAO.findAll()).thenReturn(
                makeClients()
        );

        Mockito.when(shoppingDAO.findAll()).thenReturn(
                makeShoppings()
        );

        final var bigPurchasedYear = shoppingService.findBigPurchasedYear(2018L);

        Assertions.assertNotNull(bigPurchasedYear);
        Assertions.assertEquals("User 1", bigPurchasedYear.getClientName());
        Assertions.assertEquals(123L, bigPurchasedYear.getDocument());
        Assertions.assertEquals(1, bigPurchasedYear.getClientShoppingDTOS().size());

        Assertions.assertEquals(BigDecimal.valueOf(200.0), bigPurchasedYear.getClientShoppingDTOS().get(0).getTotal());
        Assertions.assertEquals(4, bigPurchasedYear.getClientShoppingDTOS().get(0).getQuantity());
        Assertions.assertNotNull(bigPurchasedYear.getClientShoppingDTOS().get(0).getProduct());

        Assertions.assertEquals(2018L, bigPurchasedYear.getClientShoppingDTOS().get(0).getProduct().getPurchasedYear());
    }

    @Test
    public void shouldThrowProductNotFound() {
        Mockito.when(clientDAO.findAll()).thenReturn(
                makeClients()
        );

        Mockito.when(shoppingDAO.findAll()).thenReturn(
                makeShoppings()
        );

        Assertions.assertThrows(ProductNotFoundException.class,
                () -> shoppingService.findBigPurchasedYear(2018L));
    }
}