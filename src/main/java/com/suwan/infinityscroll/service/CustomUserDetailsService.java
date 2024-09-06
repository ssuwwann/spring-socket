package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.domain.CustomUser;
import com.suwan.infinityscroll.domain.Role;
import com.suwan.infinityscroll.domain.User;
import com.suwan.infinityscroll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional // 없으면 에러 ..
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 유저가 없습니다."));
    CustomUser customUser = new CustomUser(user, mapAuthorities(user.getRole()));
    return customUser;
  }

  private Collection<? extends GrantedAuthority> mapAuthorities(Set<Role> role) {
    return role.stream()
            .map(roleName -> new SimpleGrantedAuthority(roleName.name()))
            //.toList(); // java 16 이상부터 사용 가능?
            .collect(Collectors.toList());
  }
}
