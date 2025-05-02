package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Giả lập vai trò người dùng (trong thực tế sẽ lấy từ xác thực)
        model.addAttribute("isAdmin", true);
        model.addAttribute("isTeacher", false);
        model.addAttribute("isStudent", false);
        return "home";
    }

    @GetMapping("/thongtinchung")
    public String thongTinChung() {
        return "thongtinchung";
    }

    @GetMapping("/khungchuongtrinh")
    public String khungChuongTrinh() {
        return "khungchuongtrinh";
    }

    @GetMapping("/hocphan")
    public String hocPhan() {
        return "hocphan";
    }

    @GetMapping("/CTDT_UserViews")
    public String ctdtUserViews() {
        return "CTDT_UserViews";
    }

    @GetMapping("/decuongchitiet")
    public String deCuongChiTiet() {
        return "decuongchitiet";
    }

    @GetMapping("/kehoachdayhoc")
    public String keHoachDayHoc() {
        return "kehoachdayhoc";
    }

    @GetMapping("/kehoachmonhom")
    public String keHoachMoNhom() {
        return "kehoachmonhom";
    }

    @GetMapping("/giangvien")
    public String giangVien() {
        return "giangvien";
    }

    @GetMapping("phanconggiangday")
    public String phanCongGiangDay() {
        return "phanconggiangday";
    }

    @GetMapping("/thongke")
    public String thongKe() {
        return "thongke";
    }
}
