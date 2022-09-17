package com.example.scouter.product;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    @Transactional
    int createProducts();

    ProductDto getProductById(long id);

    List<ProductDto> getAllProducts();
}
