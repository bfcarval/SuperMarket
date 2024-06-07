package com.supermarket.api.feign;

import com.supermarket.api.feign.model.ClientFeignResponse;
import com.supermarket.api.feign.model.ProductFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "mockClient", url = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com")
public interface MockClient {

    @GetMapping("/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json")
    List<ProductFeignResponse> getProducts();


    @GetMapping("/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json")
    List<ClientFeignResponse> getClients();
}
