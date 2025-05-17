package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "danhgiabophan")
public class DanhGiaBoPhan {
    @Id
    @Column(name = "madiemdanhgia")
    private int maDiemDanhGia;

    @ManyToOne
    @JoinColumn(name = "mabophan", referencedColumnName = "mabophan", nullable = false)
    private DeCuongChiTiet maBoPhan;

    @Column(name = "trongso")
    @NotNull(message = "Trọng số không được để trống!")
    @Min(value = 0, message = "Trọng số không được âm!")
    private float trongSo;

    @Column(name = "hinhthucdanhgia")
    @NotNull(message = "Hình thức đánh giá học sinh không được để trống!")
    private String hinhThucDanhGia;

    public DanhGiaBoPhan() {}

    public DanhGiaBoPhan(int maDiemDanhGia, DeCuongChiTiet maBoPhan, float trongSo, String hinhThucDanhGia) {
        this.maDiemDanhGia = maDiemDanhGia;
        this.maBoPhan = maBoPhan;
        this.trongSo = trongSo;
        this.hinhThucDanhGia = hinhThucDanhGia;
    }

    public int getMaDiemDanhGia() { return maDiemDanhGia; }
    public void setMaDiemDanhGia(int maDiemDanhGia) { this.maDiemDanhGia = maDiemDanhGia; }
    public DeCuongChiTiet getMaBoPhan() { return maBoPhan; }
    public void setMaBoPhan(DeCuongChiTiet maBoPhan) { this.maBoPhan = maBoPhan; }
    public float getTrongSo() { return trongSo; }
    public void setTrongSo(float trongSo) { this.trongSo = trongSo; }
    public String getHinhThucDanhGia() { return hinhThucDanhGia; }
    public void setHinhThucDanhGia(String hinhThucDanhGia) { this.hinhThucDanhGia = hinhThucDanhGia; }
}