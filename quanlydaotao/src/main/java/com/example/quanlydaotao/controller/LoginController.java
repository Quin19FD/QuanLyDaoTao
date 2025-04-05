// package com.example.quanlydaotao.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class LoginController {

//     @GetMapping("/login")
//     public String login(@RequestParam(value = "error", required = false) String error, Model model) {
//         if (error != null) {
//             model.addAttribute("error", "Đăng nhập thất bại. Vui lòng thử lại.");
//         }
//         return "login";  // Trả về trang đăng nhập (login.html)
//     }
// }
