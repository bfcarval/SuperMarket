package com.supermarket.api.web.controller;

import com.supermarket.api.service.ClientService;
import com.supermarket.api.web.mapper.ClientWebMapper;
import com.supermarket.api.web.mapper.ProductWebMapper;
import com.supermarket.api.web.model.ProductResponse;
import com.supermarket.api.web.model.TopClientResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/v1")
@Api(
        description = "API Gerenciamento de Clientes",
        tags = ("SuperMarket - Gerenciar Clientes")
)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clientes-fieis")
    @ApiOperation("Retorna o Top 3 clientes mais fieis")
    public ResponseEntity<List<TopClientResponse>> fidelityClients() {
        return ResponseEntity.ok(
                clientService.findTopThreeClients().stream().map(ClientWebMapper::topClientDTOToResponse).collect(Collectors.toList())
        );
    }

    @GetMapping("/recomendacao/cliente/tipo")
    @ApiOperation("Retorna uma recomendação de vinho")
    public ResponseEntity<List<ProductResponse>> getWineRecommendation() {
        return ResponseEntity.ok(
                clientService.getWineRecommendation().stream().map(ProductWebMapper::productDTOToResponse).collect(Collectors.toList())
        );
    }
}
