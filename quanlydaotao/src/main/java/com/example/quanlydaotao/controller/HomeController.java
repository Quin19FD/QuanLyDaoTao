package com.example.quanlydaotao.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            
            model.addAttribute("username", username);
            model.addAttribute("authorities", authorities);
            
            // Kiểm tra role và thêm vào model
            boolean isAdmin = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
            boolean isTeacher = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER")); 
            boolean isStudent = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"));
            
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("isTeacher", isTeacher);
            model.addAttribute("isStudent", isStudent);
            
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/admin/phanconggiangday")
    public String showPhancongGiangDay(Model model) {
        return "phanconggiangday";
    }
}
