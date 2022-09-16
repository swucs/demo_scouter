package com.example.scouter.product;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    @Transactional
    int createProducts();

    List<ProductDto> getAllProducts();
}
