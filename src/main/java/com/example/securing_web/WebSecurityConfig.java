package com.example.securing_web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.securing_web.security.CustomAuthenticationSuccessHandler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  private final CustomAuthenticationSuccessHandler successHandler;

  @Autowired
  public WebSecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
    this.successHandler = successHandler;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(requests -> requests
        .requestMatchers("/", "/home", "/login", "/css/**", "/js/**", "/images/**").permitAll()
        .requestMatchers("/patient/**").hasRole("PATIENT")
        .requestMatchers("/doctor/**").hasRole("DOCTOR")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
      )
      .formLogin(form -> form
        .loginPage("/login")
        .loginProcessingUrl("/perform_login")
        .successHandler(successHandler)
        .failureUrl("/login?error=true")
        .permitAll()
      )
      .logout(logout -> logout
        .logoutUrl("/perform_logout")
        .logoutSuccessUrl("/home")
        .permitAll());

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails patientUser = User.builder()
            .username("patient")
            .password(passwordEncoder().encode("password"))
            .roles("PATIENT")
            .build();

    UserDetails doctorUser = User.builder()
            .username("doctor")
            .password(passwordEncoder().encode("password"))
            .roles("DOCTOR")
            .build();

    UserDetails adminUser = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("password"))
            .roles("ADMIN")
            .build();

    return new InMemoryUserDetailsManager(patientUser, doctorUser, adminUser);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

