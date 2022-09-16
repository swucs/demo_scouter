package com.example.scouter.user;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    int createUsers();

    List<UserDto> getAllUsers();
}
