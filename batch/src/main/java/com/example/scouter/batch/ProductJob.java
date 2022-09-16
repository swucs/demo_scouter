package com.example.scouter.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductJob {

    private final ProductClient productClient;

    @Scheduled(fixedRate = 1000 * 13)
    public void scheduleProductCreator() {
        int createdCount = productClient.createProducts();
        System.out.println("createdProductCount : " + createdCount);
    }
}
