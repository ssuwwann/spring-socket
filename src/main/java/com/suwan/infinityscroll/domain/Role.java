package com.suwan.infinityscroll.domain;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.suwan.infinityscroll.domain.Permission.*;

@Getter
public enum Role {
  ROLE_GUEST(Set.of(READ)),
  ROLE_USER(Set.of(READ, CREATE, UPDATE, DELETE)),
  ROLE_ADMIN(Set.of(READ, CREATE, UPDATE, DELETE));

  private final Set<Permission> permissions;

  Role(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public List<SimpleGrantedAuthority> getAuthority() {
    List<SimpleGrantedAuthority> authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());

    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

    return authorities;
  }
}
