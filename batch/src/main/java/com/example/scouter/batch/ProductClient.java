package com.example.scouter.batch;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
    name="ProductClient"
    , url = "http://localhost:8089"
)
public interface ProductClient {
    @PostMapping("/api/products")
    int createProducts();
}
