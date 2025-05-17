package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    // Hiển thị trang profile
    @GetMapping
    public String showProfile(@RequestParam String username, Model model) {
        TaiKhoan user = taiKhoanRepo.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        
        model.addAttribute("user", user);
        return "profile";
    }

    // API cập nhật thông tin profile
    @PostMapping("/api/update")
    @ResponseBody
    public ResponseEntity<?> updateProfile(@RequestBody TaiKhoan updatedUser) {
        try {
            TaiKhoan existingUser = taiKhoanRepo.findByUserName(updatedUser.getUserName())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

            // Chỉ cập nhật email và số điện thoại
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setSdt(updatedUser.getSdt());

            taiKhoanRepo.save(existingUser);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Cập nhật thông tin thành công");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Có lỗi xảy ra: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // API đổi mật khẩu
    @PostMapping("/api/change-password")
    @ResponseBody
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> passwords) {
        try {
            String username = passwords.get("username");
            String currentPassword = passwords.get("currentPassword");
            String newPassword = passwords.get("newPassword");

            TaiKhoan user = taiKhoanRepo.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

            // Kiểm tra mật khẩu hiện tại
            if (!user.getPassword().equals(currentPassword)) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "Mật khẩu hiện tại không đúng");
                return ResponseEntity.badRequest().body(response);
            }

            // Cập nhật mật khẩu mới
            user.setPassword(newPassword);
            taiKhoanRepo.save(user);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Đổi mật khẩu thành công");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Có lỗi xảy ra: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
} 