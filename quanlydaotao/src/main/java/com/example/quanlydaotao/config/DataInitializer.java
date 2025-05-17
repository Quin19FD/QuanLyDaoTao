package com.example.quanlydaotao.config;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Component
@ConditionalOnProperty(name = "app.init-data", havingValue = "true", matchIfMissing = false)
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Tạo tài khoản admin nếu chưa có
        if (taiKhoanRepo.findById("admin123").isEmpty()) {
            TaiKhoan admin = new TaiKhoan();
            admin.setUserName("admin123");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setTenUser("Quản trị viên");
            admin.setEmail("admin@example.com");
            admin.setSdt("0123456789");
            admin.setVaiTro("ADMIN");
            admin.setNamSinh(1990L);
            admin.setTrangThai(1);
            taiKhoanRepo.save(admin);
            System.out.println("Đã tạo tài khoản admin mặc định");
        }

        // Tạo tài khoản sinh viên nếu chưa có
        if (taiKhoanRepo.findById("sinhvien01").isEmpty()) {
            TaiKhoan sinhvien = new TaiKhoan();
            sinhvien.setUserName("sinhvien01");
            sinhvien.setPassword(passwordEncoder.encode("123456"));
            sinhvien.setTenUser("Nguyễn Văn Sinh Viên");
            sinhvien.setEmail("sinhvien01@example.com");
            sinhvien.setSdt("0987654321");
            sinhvien.setVaiTro("USER");
            sinhvien.setNamSinh(2002L);
            sinhvien.setTrangThai(1);
            taiKhoanRepo.save(sinhvien);
            System.out.println("Đã tạo tài khoản sinh viên mặc định");
        }

        // Tạo tài khoản giảng viên nếu chưa có
        if (taiKhoanRepo.findById("giangvien01").isEmpty()) {
            TaiKhoan giangvien = new TaiKhoan();
            giangvien.setUserName("giangvien01");
            giangvien.setPassword(passwordEncoder.encode("123456"));
            giangvien.setTenUser("Trần Thị Giảng Viên");
            giangvien.setEmail("giangvien01@example.com");
            giangvien.setSdt("0911222333");
            giangvien.setVaiTro("GIANG_VIEN");
            giangvien.setNamSinh(1985L);
            giangvien.setTrangThai(1);
            taiKhoanRepo.save(giangvien);
            System.out.println("Đã tạo tài khoản giảng viên mặc định");
        }
    }
}
