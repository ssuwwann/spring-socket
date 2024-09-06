package com.suwan.infinityscroll.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable());

    //http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.formLogin(login -> login
            .loginPage("/login")
            .loginProcessingUrl("/login-proc")
            .defaultSuccessUrl("/", true));

    http.httpBasic(basic -> basic.disable());

    http.authorizeHttpRequests(request -> request
            .requestMatchers("/**").permitAll()
    );

    return http.build();
  }

  @Bean
  public SecurityUtil securityUtil() {
    return new SecurityUtil();
  }

  @Bean
  public static BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
