package com.supermarket.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SuperMarketApi {

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApi.class, args);
    }
}
