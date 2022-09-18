package com.example.scouter.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ProductJob {

    private final ProductClient productClient;

    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 1000 * 13)
    public void scheduleProductCreator() {
//        int createdCount = productClient.createProducts();
//        System.out.println("createdProductCount : " + createdCount);

        ResponseEntity<Integer> response
                = restTemplate.postForEntity("http://localhost:8089/api/products", null, Integer.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("createdProductCount : " + response.getBody());
        }
    }
}
