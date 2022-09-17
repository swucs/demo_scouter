package com.example.scouter.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name="ProductClient"
    , url = "http://localhost:8089"
)
public interface ProductClient {
    @GetMapping("/api/product/{id}")
    ProductDto getProduct(@PathVariable("id") long id);
}
