package com.example.scouter.batch;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
    name="UserClient"
    , url = "http://localhost:8088"
)
public interface UserClient {

    @PostMapping("/api/users")
    int createUsers();
}
