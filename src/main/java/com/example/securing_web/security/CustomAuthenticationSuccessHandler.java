package com.example.securing_web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_PATIENT")) {
            response.sendRedirect("/patient/dashboard");
        } else if (roles.contains("ROLE_DOCTOR")) {
            response.sendRedirect("/doctor/dashboard");
        } else if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/admin/doctors");
        } else {
            response.sendRedirect("/login");
        }
    }
}
