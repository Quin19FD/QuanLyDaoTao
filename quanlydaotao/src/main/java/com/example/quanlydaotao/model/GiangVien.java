package com.example.quanlydaotao.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //kiet
@Table(name = "giangvien")
public class GiangVien {
    @Id
    @Column(name = "magv", nullable = false)
    private int maGV;

    @Column(name = "hoten")
    @NotNull(message = "Tên giảng viên không được để trống!")
    private String hoTen;

    @Column(name = "ngaysinh")
    @NotNull(message = "Ngày sinh không được để trống!")
    private LocalDate ngaySinh;

    @Column(name = "gioitinh")
    @NotNull(message = "Giới tính không được để trống!")
    private String gioiTinh;

    @Column(name = "hocvi")
    @NotNull(message = "Học vị không được để trống!")
    private String hocVi;

    @Column(name = "chuyennganh")
    @NotNull(message = "Chuyên ngành không được để trống!")
    private String chuyenNganh;

    @Column(name = "sdt")
    @NotNull(message = "Số điện thoại không được để trống!")
    private String sdt;

    @Column(name = "email")
    @NotNull(message = "Email không được để trống!")
    private String email;

    // Không có các cột 'congtackhac' và 'tongCLC' trong schema bạn cung cấp

    public GiangVien() {
    }

    public GiangVien(int maGV, String hoTen, LocalDate ngaySinh, String gioiTinh, String hocVi, String chuyenNganh, String sdt, String email) {
        this.maGV = maGV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.hocVi = hocVi;
        this.chuyenNganh = chuyenNganh;
        this.sdt = sdt;
        this.email = email;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
