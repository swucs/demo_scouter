package com.example.scouter.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;


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
                .map(u -> {
                    UserDto userDto = u.toUserDto();

                    try {
                        ResponseEntity<ProductDto> response
                                = restTemplate.getForEntity("http://localhost:8089/api/product/" + u.getId(), ProductDto.class);
                        if (response.getStatusCode() == HttpStatus.OK) {
                            ProductDto product = response.getBody();
                            userDto.setProductNo(product.getNo());
                            userDto.setProductName(product.getName());
                        }
                    } catch (Exception e) {
                        log.error("", e);
                    }
                    return userDto;
                })
                .collect(Collectors.toList());
    }
}
