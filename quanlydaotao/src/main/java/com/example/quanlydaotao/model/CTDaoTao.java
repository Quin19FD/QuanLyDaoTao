package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ctdaotao")
public class CTDaoTao {
    @Id
    @Column(name = "mactdt", nullable = false)
    private int maCTDT;

    @Column(name = "tenctdt")
    @NotNull(message = "Tên ngành không được để trống!")
    private String tenCTDT;

    @Column(name = "bac")
    @NotNull(message = "Bậc không được để trống!")
    private String bac;

    @Column(name = "loaibang")
    @NotNull(message = "Loại bằng không được để trống!")
    private String loaiBang;

    @Column(name = "loaihinhdaotao")
    @NotNull(message = "Loại hình đào tạo không được để trống!")
    private String loaiHinhDaoTao;

    @Column(name = "thoigian")
    @NotNull(message = "Thời gian không được để trống!")
    @Min(value = 0, message = "Thời gian không được âm!")
    private float thoiGian;

    @Column(name = "sotintoithieu")
    @NotNull(message = "Số tín tối thiểu không được để trống!")
    @Min(value = 0, message = "Số tín tối thiểu không được âm!")
    private int soTinToiThieu;

    @Column(name = "khoaquanly")
    @NotNull(message = "Khoa quản lý không được để trống!")
    private String khoaQuanLy;

    @Column(name = "ngonngu")
    @NotNull(message = "Ngôn ngữ không được để trống!")
    private String ngonNgu;

    @Column(name = "banhanh")
    @NotNull(message = "Ban hành không được để trống!")
    private String banHanh;

    public CTDaoTao() {}

    public CTDaoTao(int maCTDT, String tenCTDT, String bac, String loaiBang, String loaiHinhDaoTao, float thoiGian, int soTinToiThieu, String khoaQuanLy, String ngonNgu, String banHanh) {
        this.maCTDT = maCTDT;
        this.tenCTDT = tenCTDT;
        this.bac = bac;
        this.loaiBang = loaiBang;
        this.loaiHinhDaoTao = loaiHinhDaoTao;
        this.thoiGian = thoiGian;
        this.soTinToiThieu = soTinToiThieu;
        this.khoaQuanLy = khoaQuanLy;
        this.ngonNgu =ngonNgu;
        this.banHanh = banHanh;
    }

    public int getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(int maCTDT) {
        this.maCTDT = maCTDT;
    }

    public String getTenCTDT() {
        return tenCTDT;
    }

    public void setTenCTDT(String tenCTDT) {
        this.tenCTDT = tenCTDT;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    public String getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(String loaiBang) {
        this.loaiBang = loaiBang;
    }

    public String getLoaiHinhDaoTao() {
        return loaiHinhDaoTao;
    }

    public void setLoaiHinhDaoTao(String loaiHinhDaoTao) {
        this.loaiHinhDaoTao = loaiHinhDaoTao;
    }

    public float getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(float thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSoTinToiThieu() {
        return soTinToiThieu;
    }

    public void setSoTinToiThieu(int soTinToiThieu) {
        this.soTinToiThieu = soTinToiThieu;
    }

    public String getKhoaQuanLy() {
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy) {
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getBanHanh() {
        return banHanh;
    }

    public void setBanHanh(String banHanh) {
        this.banHanh = banHanh;
    }
}
