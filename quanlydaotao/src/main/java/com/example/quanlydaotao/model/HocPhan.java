package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hocphan")
public class HocPhan {
    @Id
    @Column(name = "mahocphan")
    private String maHocPhan;

    @ManyToOne
    @JoinColumn(name = "mactdt", referencedColumnName = "mactdt", nullable = false)
    private CTDaoTao maDaoTao;

    @Column(name = "tenHocPhan")
    @NotNull(message = "Tên học phần không được để trống!")
    private String tenHocPhan;

    @Column(name = "soTinChi")
    @NotNull(message = "Số tín chỉ không được để trống!")
    @Min(value = 0, message = "Số tín chỉ không được âm!")
    private int soTinChi;

    @Column(name = "heSo")
    @NotNull(message = "Hệ số không được để trống!")
    @Min(value = 0, message = "Hệ số không được âm!")
    private float heSo;

    // Getters & Setters
    public HocPhan() {}

    public HocPhan(String maHocPhan, CTDaoTao maDaoTao, String tenHocPhan, int soTinChi, float heSo) {
        this.maHocPhan = maHocPhan;
        this.maDaoTao = maDaoTao;
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.heSo = heSo;
    }

    public String getMaHocPhan() { return maHocPhan; }
    public void setMaHocPhan(String maHocPhan) { this.maHocPhan = maHocPhan; }
    public CTDaoTao getMaDaoTao() { return maDaoTao; }
    public void setMaDaoTao(CTDaoTao maDaoTao) { this.maDaoTao = maDaoTao; }
    public String getTenHocPhan() { return tenHocPhan; }
    public void setTenHocPhan(String tenHocPhan) { this.tenHocPhan = tenHocPhan; }
    public int getSoTinChi() { return soTinChi; }
    public void setSoTinChi(int soTinChi) { this.soTinChi = soTinChi; }
    public float getHeSo() { return heSo; }
    public void setHeSo(float heSo) { this.heSo = heSo; }
}