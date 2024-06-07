package com.supermarket.api.web.controller;

import com.supermarket.api.service.ShoppingService;
import com.supermarket.api.web.mapper.ShoppingWebMapper;
import com.supermarket.api.web.model.TotalShoppingResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.supermarket.api.web.mapper.ShoppingWebMapper.shoppingDTOToResponse;

@RestController
@RequestMapping("/shopping/v1")
@Api(
        description = "API Gerenciamento de Compras",
        tags = ("SuperMarket - Gerenciar Compras")
)
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/compras")
    @ApiOperation("Retorna uma lista das compras")
    public ResponseEntity<List<TotalShoppingResponse>> findAll() {
        return ResponseEntity.ok(
                shoppingService.findAll().stream().map(ShoppingWebMapper::shoppingDTOToResponse).collect(Collectors.toList())
        );
    }

    @GetMapping("/maior-compra/{ano}")
    @ApiOperation("Retorna a maior compra do ano")
    public ResponseEntity<TotalShoppingResponse> findBigPurchase(@PathVariable("ano") final Long year) {
        return ResponseEntity.ok(
                shoppingDTOToResponse(shoppingService.findBigPurchasedYear(year))
        );
    }
}