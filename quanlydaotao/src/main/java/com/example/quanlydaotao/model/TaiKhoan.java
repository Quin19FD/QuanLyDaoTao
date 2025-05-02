package com.example.quanlydaotao.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @Column(name = "username")
    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Size(min = 6, message = "Tên đăng nhập phải có ít nhất 6 ký tự")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "Mật khẩu không được để trống!")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự!")
    private String password;

    @Column(name = "tenuser")
    @NotBlank(message = "Tên không được để trống!")
    private String tenUser;

    @Column(name = "email")
    @NotBlank(message = "Email không được để trống!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email không đúng định dạng!")
    private String email;

    @Column(name = "sdt")
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Pattern(regexp = "^\\+?[0-9]{1,4}?[-.\\s]?[0-9]{1,15}$", message = "Số điện thoại không đúng định dạng!")
    private String sdt;

    @Column(name = "vaitro")
    private String vaiTro;

    @Column(name = "namsinh")
    private long namSinh;

    @Column(name = "trangthai")
    private int trangThai;

    // Constructors
    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String password, String tenUser, String email, String sdt, String vaiTro, long namSinh, int trangThai) {
        this.userName = userName;
        this.password = password;
        this.tenUser = tenUser;
        this.email = email;
        this.sdt = sdt;
        this.vaiTro = vaiTro;
        this.namSinh = namSinh;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public long getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(long namSinh) {
        this.namSinh = namSinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
