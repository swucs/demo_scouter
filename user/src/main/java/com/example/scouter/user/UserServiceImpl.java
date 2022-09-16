package com.example.scouter.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Transactional
    @Override
    public int createUsers() {

        final int userCount = 20;

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        for (int i = 0; i < userCount; i++) {
            User user = User.builder()
                    .name("사용자_" + now + "_" + i)
                    .email("user_" + now + "_" + i + "@test.com")
                    .tel("123-456-7890")
                    .build();
            userRepository.save(user);
        }

        return userCount;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(u -> u.toUserDto())
                .collect(Collectors.toList());
    }

}
