package com.example.scouter.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Transactional
    @Override
    public int createProducts() {

        final int productCount = 20;
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        for (int i = 0; i < productCount; i++) {
            Product product = Product.builder()
                    .no("product_" + now + "_" + i)
                    .name("상품" + now + "_" + i)
                    .build();

            productRepository.save(product);
        }

        return productCount;
    }


    @Override
    public ProductDto getProductById(long id) {
//        Product product = productRepository.findById(id).orElseGet(() -> null);
//        if (product == null) {
//            return null;
//        }
//
//        return product.toProductDto();
        return productRepository.findById(id).get().toProductDto();
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(p -> p.toProductDto())
                .collect(Collectors.toList());
    }
}
