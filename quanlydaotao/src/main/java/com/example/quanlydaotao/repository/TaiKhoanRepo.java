package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, String> {
    
    // Tìm kiếm tài khoản theo username
    Optional<TaiKhoan> findByUserName(String userName);

    // Đăng nhập: kiểm tra username và password
    @Query("SELECT t FROM TaiKhoan t WHERE t.userName = :username AND t.password = :password")
    Optional<TaiKhoan> findByUserNameAndPassword(
        @Param("username") String username, 
        @Param("password") String password
    );

    // Kiểm tra tài khoản tồn tại
    boolean existsByUserName(String userName);

    // Tìm kiếm theo trạng thái
    List<TaiKhoan> findByTrangThai(Integer trangThai);

    // Tìm kiếm theo vai trò
    List<TaiKhoan> findByVaiTro(String vaiTro);

    // Tìm kiếm theo username và trạng thái
    @Query("SELECT t FROM TaiKhoan t WHERE t.userName = :username AND t.trangThai = :trangThai")
    Optional<TaiKhoan> findByUserNameAndTrangThai(
        @Param("username") String username,
        @Param("trangThai") Integer trangThai
    );
}
