package com.example.scouter.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserJob {

    private final UserClient userClient;

    private final RestTemplate restTemplate;

    /**
     * 사용자 생성 배치
     */
    @Scheduled(fixedRate = 1000 * 9)
    public void scheduleUserCreator() {
//        int createdCount = userClient.createUsers();
//        System.out.println("createdUserCount : " + createdCount);
        ResponseEntity<List> response
                = restTemplate.getForEntity("http://localhost:8088/api/users", List.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("users : " + response.getBody());
        }
    }
}
