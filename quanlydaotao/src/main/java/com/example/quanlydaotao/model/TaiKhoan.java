package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "namsinh")
    private Long namSinh;

    @Column(name = "password")
    private String password;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tenuser")
    private String tenUser;

    @Column(name = "trangthai")
    private Integer trangThai;

    @Column(name = "vaitro")
    private String vaiTro;

    // Getters và Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getNamSinh() { return namSinh; }
    public void setNamSinh(Long namSinh) { this.namSinh = namSinh; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getTenUser() { return tenUser; }
    public void setTenUser(String tenUser) { this.tenUser = tenUser; }

    public Integer getTrangThai() { return trangThai; }
    public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
}
