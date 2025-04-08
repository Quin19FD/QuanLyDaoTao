package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhancongController {

    @GetMapping("/phanconggiangday")
    public String showPhancong(Model model) {
        return "phanconggiangday";
    }
}
