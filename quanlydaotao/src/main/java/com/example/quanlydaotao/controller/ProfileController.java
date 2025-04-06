package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "profile";  // Trả về trang profile.html từ thư mục templates
    }
}
