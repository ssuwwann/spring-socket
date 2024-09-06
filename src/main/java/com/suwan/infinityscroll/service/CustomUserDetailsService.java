package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.domain.CustomUser;
import com.suwan.infinityscroll.domain.User;
import com.suwan.infinityscroll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    CustomUser customUser = new CustomUser(user);
    return customUser;
  }
}
