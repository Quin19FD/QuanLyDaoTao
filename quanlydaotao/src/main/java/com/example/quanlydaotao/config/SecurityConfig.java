// package com.example.quanlydaotao.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;



// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests()
//                 .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll() // Cho phép không xác thực các tài nguyên tĩnh
//                 .requestMatchers("/home").authenticated() // Trang home yêu cầu phải đăng nhập
//                 .anyRequest().authenticated() // Các trang khác yêu cầu phải đăng nhập
//                 .and()
//                 .formLogin()
//                 .loginPage("/login") // Trang đăng nhập của bạn
//                 .defaultSuccessUrl("/home", true) // Sau khi đăng nhập thành công, chuyển hướng về /home
//                 .failureUrl("/login?error=true") // Nếu đăng nhập thất bại
//                 .permitAll()
//                 .and()
//                 .logout()
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout=true") // Sau khi logout thành công, chuyển hướng về trang login
//                 .permitAll();

//         return http.build();
//     }
    
//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user = User.withUsername("user")  // Tạo tài khoản người dùng
//                 .password("{noop}password123")  // Dùng {noop} để bỏ mã hóa mật khẩu trong trường hợp đơn giản
//                 .roles("USER")  // Quyền của người dùng
//                 .build();

//         return new InMemoryUserDetailsManager(user);
//     }
// }
