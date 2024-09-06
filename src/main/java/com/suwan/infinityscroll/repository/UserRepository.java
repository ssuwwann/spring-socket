package com.suwan.infinityscroll.repository;

import com.suwan.infinityscroll.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
