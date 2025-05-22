package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    // Lấy danh sách tất cả tài khoản
    @GetMapping
    public List<TaiKhoan> getAll() {
        return taiKhoanRepo.findAll();
    }

    // Tìm kiếm tài khoản theo userName
    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return taiKhoanRepo.findByUserName(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // // Đăng ký tài khoản
    // @PostMapping("/register")
    // public ResponseEntity<?> dangKy(@Valid @RequestBody TaiKhoan taiKhoan, BindingResult result) {
    //     if (result.hasErrors()) {
    //         return ResponseEntity.badRequest().body(result.getAllErrors());
    //     }

    //     if (taiKhoanRepo.findByUserName(taiKhoan.getUserName()).isPresent()) {
    //         return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại!");
    //     }

    //     taiKhoan.setTrangThai(1); // Mặc định là đang hoạt động
    //     return ResponseEntity.ok(taiKhoanRepo.save(taiKhoan));
    // }

     // Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> dangNhap(@RequestBody TaiKhoan loginInfo) {
        Optional<TaiKhoan> optional = taiKhoanRepo.findByUserName(loginInfo.getUserName());

        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Tài khoản không tồn tại!");
        }

        TaiKhoan taiKhoan = optional.get();
        
        // Check trạng thái tài khoản trước khi kiểm tra mật khẩu
        if (taiKhoan.getTrangThai() == null || taiKhoan.getTrangThai() != 1) {
            return ResponseEntity.status(403).body("Tài khoản đã bị khóa!");
        }

        // Check mật khẩu
        if (!taiKhoan.getPassword().equals(loginInfo.getPassword())) {
            return ResponseEntity.badRequest().body("Sai mật khẩu!");
        }

        return ResponseEntity.ok(taiKhoan);
    }
    // Cập nhật thông tin tài khoản
    @PutMapping("/{username}")
    public ResponseEntity<?> updateThongTin(@PathVariable String username, @Valid @RequestBody TaiKhoan updated, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Optional<TaiKhoan> optional = taiKhoanRepo.findByUserName(username);
        if (optional.isPresent()) {
            TaiKhoan existing = optional.get();
            existing.setPassword(updated.getPassword());
            existing.setTenUser(updated.getTenUser());
            existing.setEmail(updated.getEmail());
            existing.setSdt(updated.getSdt());
            existing.setVaiTro(updated.getVaiTro());
            existing.setNamSinh(updated.getNamSinh());
            existing.setTrangThai(updated.getTrangThai());

            return ResponseEntity.ok(taiKhoanRepo.save(existing));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa tài khoản
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteTaiKhoan(@PathVariable String username) {
        Optional<TaiKhoan> optional = taiKhoanRepo.findByUserName(username);
        if (optional.isPresent()) {
            taiKhoanRepo.deleteById(username);
            return ResponseEntity.ok("Đã xóa tài khoản: " + username);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Khóa tài khoản
    @Transactional
    @PutMapping("/lock/{username}")
    public ResponseEntity<?> khoaTaiKhoan(@PathVariable String username) {
        Optional<TaiKhoan> optional = taiKhoanRepo.findByUserName(username);
        if (optional.isPresent()) {
            TaiKhoan tk = optional.get();

            if (tk.getTrangThai() != null && tk.getTrangThai() == 0) {
                return ResponseEntity.badRequest().body("Tài khoản đã bị khóa!");
            }

            tk.setTrangThai(0);
            taiKhoanRepo.save(tk);
            return ResponseEntity.ok("Đã khóa tài khoản: " + username);
        }
        return ResponseEntity.notFound().build();
    }
    // Mở khóa tài khoản
    @PutMapping("/unlock/{username}")
    public ResponseEntity<?> moTaiKhoan(@PathVariable String username) {
        Optional<TaiKhoan> optional = taiKhoanRepo.findByUserName(username);
        if (optional.isPresent()) {
            TaiKhoan tk = optional.get();
            tk.setTrangThai(1); // 1 = hoạt động
            taiKhoanRepo.save(tk);
            return ResponseEntity.ok("Tài khoản đã được mở khóa: " + username);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
