/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.conf;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Tesla
 */
@Configuration
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Proveedor de codificación de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // Configuración del filtro de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(requests -> 
                    requests
                            .requestMatchers("/public/**").permitAll()   // Permite acceso sin autenticación a rutas públicas
                            .requestMatchers("/api/**").permitAll() 
                            .requestMatchers("/swagger-ui/**").permitAll()
                            .requestMatchers("/v3/**").permitAll()
                            .requestMatchers("/*").permitAll()
                    .anyRequest().authenticated()                        // Requiere autenticación para otras rutas
            )
            // Soporte para autenticación mediante formulario
//            .formLogin(fL -> fL.loginPage("/login") 
//                .usernameParameter("username").permitAll()
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/login-error")
//            )
            .httpBasic(Customizer.withDefaults()); // Soporte para autenticación básica HTTP

        return http.build();
    }

    // Configuración de usuarios en memoria
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user1 = User.builder()
//            .username("admin")
//            .password(passwordEncoder.encode("password"))
//            .roles("ADMIN")
//            .build();
//
//        UserDetails user2 = User.builder()
//            .username("user")
//            .password(passwordEncoder.encode("password"))
//            .roles("USER")
//            .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
    
    
    // Configuración de usuarios en bbdd
     @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(
            "SELECT username, password, enabled FROM user WHERE username = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT username, role FROM roles WHERE username = ?");
        return userDetailsManager;
    }

    
}