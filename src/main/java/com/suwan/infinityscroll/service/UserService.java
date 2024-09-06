package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.config.SecurityConfig;
import com.suwan.infinityscroll.domain.Role;
import com.suwan.infinityscroll.domain.User;
import com.suwan.infinityscroll.domain.dto.UserRequestDTO;
import com.suwan.infinityscroll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public Long addUser(UserRequestDTO dto) {
    User entity = User.builder()
            .username(dto.getUsername())
            .password(passwordEncoder.encode(dto.getPassword()))
            .role(Set.of(Role.ROLE_USER))
            .nickname(dto.getNickname())
            .build();

    userRepository.save(entity);

    return entity.getId();
  }

}
