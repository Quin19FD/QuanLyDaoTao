package com.example.quanlydaotao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Tạm thời disable CSRF để test
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/teacher/**").hasRole("TEACHER")
                .requestMatchers("/student/**").hasRole("STUDENT")
                .requestMatchers("/home", "/profile").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
            );

        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        // Tài khoản Admin
        UserDetails admin1 = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        // UserDetails admin2 = User.withUsername("admin2")
        //         .password("{noop}admin456")
        //         .roles("ADMIN")
        //         .build();

        // Tài khoản Giáo viên
        UserDetails teacher1 = User.withUsername("teacher")
                .password("{noop}teacher123")
                .roles("TEACHER")
                .build();

        // UserDetails teacher2 = User.withUsername("teacher2")
        //         .password("{noop}teacher456")
        //         .roles("TEACHER")
        //         .build();

        // UserDetails teacher3 = User.withUsername("teacher3")
        //         .password("{noop}teacher789")
        //         .roles("TEACHER")
        //         .build();

        // Tài khoản Học sinh
        UserDetails student1 = User.withUsername("student")
                .password("{noop}student123")
                .roles("STUDENT")
                .build();

        // UserDetails student2 = User.withUsername("student2")
        //         .password("{noop}student456")
        //         .roles("STUDENT")
        //         .build();

        // UserDetails student3 = User.withUsername("student3")
        //         .password("{noop}student789")
        //         .roles("STUDENT")
        //         .build();

        return new InMemoryUserDetailsManager(admin1, teacher1, student1);
    }
}
