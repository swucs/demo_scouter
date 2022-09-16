package com.example.scouter.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserJob {

    private final UserClient userClient;

    /**
     * 사용자 생성 배치
     */
    @Scheduled(fixedRate = 1000 * 9)
    public void scheduleUserCreator() {
        int createdCount = userClient.createUsers();
        System.out.println("createdUserCount : " + createdCount);
    }
}
