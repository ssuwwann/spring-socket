package com.suwan.infinityscroll.controller;

import com.suwan.infinityscroll.domain.dto.UserRequestDTO;
import com.suwan.infinityscroll.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/login")
  public void moveToLogin() {
  }

  @GetMapping("/join")
  public void moveToJoin() {
  }

  @PostMapping("/join")
  public String join(UserRequestDTO dto) {
    Long id = userService.addUser(dto);
    if (id != null) return "redirect:/";
    else return "redirect:/login";
  }

}
