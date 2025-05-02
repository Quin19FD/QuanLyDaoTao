package com.example.quanlydaotao.config;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra xem đã có tài khoản admin chưa
        if (taiKhoanRepo.findByUserName("admin123").isEmpty()) {
            // Tạo tài khoản admin mặc định
            TaiKhoan admin = new TaiKhoan();
            admin.setUserName("admin123");
            admin.setPassword("admin123");
            admin.setTenUser("Quản trị viên");
            admin.setEmail("admin@example.com");
            admin.setSdt("0123456789");
            admin.setVaiTro("ADMIN");
            admin.setNamSinh(1990);
            admin.setTrangThai(1);
            
            taiKhoanRepo.save(admin);
            System.out.println("Đã tạo tài khoản admin mặc định");
        }
    }
}
