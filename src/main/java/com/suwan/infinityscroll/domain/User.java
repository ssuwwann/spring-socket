package com.suwan.infinityscroll.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 60, unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(length = 30, nullable = false)
  private String nickname;

  @ElementCollection(targetClass = Role.class)
  @Enumerated(EnumType.STRING)
  private Set<Role> role;
}
