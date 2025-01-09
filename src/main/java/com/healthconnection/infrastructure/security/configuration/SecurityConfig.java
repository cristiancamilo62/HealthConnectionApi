package com.healthconnection.infrastructure.security.configuration;

import com.healthconnection.infrastructure.security.filters.JwtAuthenticationFilter;
import com.healthconnection.infrastructure.security.jwt.JwtService;
import com.healthconnection.infrastructure.security.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private JwtService jwtService;
    private UserDetailsService customUserDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(authorize ->
                authorize
                    .requestMatchers("/api/v1/auth/login").permitAll()
                    .requestMatchers("/api/v1/eps/consultar").permitAll()
                        .requestMatchers("/api/v1/eps/dummy").permitAll()
                    .requestMatchers("/api/v1/identifications/consultar").permitAll()
                    .requestMatchers("/api/v1/affiliationregime/consultar").permitAll()
                    .requestMatchers("/api/v1/patients/register").permitAll()
                    .requestMatchers("/api/v1/professional/register").permitAll()
                    .requestMatchers("/api/v1/roles/consultar").permitAll()
                    .requestMatchers("/api/v1/services/consultar").permitAll()
                    .requestMatchers("/api/v1/cloudinary/upload").permitAll()
                    .requestMatchers("/api/v1/professional/consultar").permitAll()
                    .requestMatchers("/verify-email/**").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService, (CustomUserDetailsService) customUserDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


