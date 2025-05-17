package com.example.quanlydaotao.service;

import com.example.quanlydaotao.model.TaiKhoan;
import com.example.quanlydaotao.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Đang tìm kiếm user: " + username);
        
        TaiKhoan taiKhoan = taiKhoanRepo.findByUserName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        System.out.println("Tìm thấy user: " + taiKhoan.getUserName());
        System.out.println("Password: " + taiKhoan.getPassword());
        System.out.println("Vai trò: " + taiKhoan.getVaiTro());

        return User.builder()
            .username(taiKhoan.getUserName())
            .password(taiKhoan.getPassword())
            .authorities("ROLE_" + taiKhoan.getVaiTro().toLowerCase())
            .disabled(false)
            .accountExpired(false)
            .credentialsExpired(false)
            .accountLocked(false)
            .build();
    }
} 