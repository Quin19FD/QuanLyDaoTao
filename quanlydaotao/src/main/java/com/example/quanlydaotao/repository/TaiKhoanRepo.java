package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, String>{
    // Tìm kiếm tài khoản theo username
    Optional<TaiKhoan> findByUserName(String userName);


    // Đăng nhập: kiểm tra username và password
    Optional<TaiKhoan> findByUserNameAndPassword(String userName, String password);
}
