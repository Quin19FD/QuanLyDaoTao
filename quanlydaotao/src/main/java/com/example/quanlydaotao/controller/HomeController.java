package com.example.quanlydaotao.controller;

// import
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller
// public class HomeController {

//     @GetMapping("/home")
//     public String home(Model model) {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

//         if (authentication != null && authentication.isAuthenticated()) {
//             String username = authentication.getName();
//             model.addAttribute("username", username);  // Thêm tên người dùng vào model
//         } else {
//             model.addAttribute("error", "Bạn chưa đăng nhập.");
//         }

//         return "home";  // Trả về trang home.html
//     }
// }

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";  // Trả về trang home.html, không kiểm tra đăng nhập
    }
}
