package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.domain.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

  @Autowired
  UserService userService;

  @Test
  void addUser() {
    UserRequestDTO dto = new UserRequestDTO();
    dto.setUsername("suwan");
    dto.setNickname("nicksuwan");
    userService.addUser(dto);
  }
}