package com.example.quanlydaotao.service;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    public TaiKhoan dangKy(TaiKhoan taiKhoan) {
        // Kiểm tra username đã tồn tại chưa
        if (taiKhoanRepo.findByUserName(taiKhoan.getUserName()).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại");
        }

        // Lưu mật khẩu dạng plain text
        taiKhoan.setPassword(taiKhoan.getPassword());
        
        // Mặc định trạng thái là hoạt động
        taiKhoan.setTrangThai(1);
        
        return taiKhoanRepo.save(taiKhoan);
    }

    public TaiKhoan capNhatMatKhau(String username, String matKhauMoi) {
        TaiKhoan taiKhoan = taiKhoanRepo.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
        
        // Lưu mật khẩu dạng plain text
        taiKhoan.setPassword(matKhauMoi);
        return taiKhoanRepo.save(taiKhoan);
    }

    public TaiKhoan layThongTin(String username) {
        return taiKhoanRepo.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
    }
} 