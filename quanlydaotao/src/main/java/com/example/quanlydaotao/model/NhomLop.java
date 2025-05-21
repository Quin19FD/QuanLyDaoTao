package com.example.quanlydaotao.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nhomlop")
public class NhomLop {
    @Id
    @Column(name = "manhom", nullable = false)
    private int maNhom;

    @ManyToOne
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    private HocPhan maHocPhan;

    @ManyToOne
    @JoinColumn(name = "mapc", referencedColumnName = "mapc", nullable = false)
    private PhanCongGiangDay maPC;

    @Column(name = "sltoida")
    @NotNull(message = "Số lượng tối đa không được để trống!")
    @Min(value = 0, message = "Số lượng tối đa không được âm!")
    private int soLuongToiDa;

    @Column(name = "diachi")
    @NotNull(message = "Địa chỉ không được để trống!")
    private String diaChi;

    @Column(name = "thudi")
    private String thuDi;

    @Column(name = "tietbatdau")
    private Integer tietBatDau;

    @Column(name = "sotiet")
    private Integer soTiet;

    public NhomLop(){
    }

    public NhomLop(int maNhom, HocPhan maHocPhan, PhanCongGiangDay maPC, int soLuongToiDa, String diaChi, String thuDi, Integer tietBatDau, Integer soTiet) {
        this.maNhom = maNhom;
        this.maHocPhan = maHocPhan;
        this.maPC = maPC;
        this.soLuongToiDa = soLuongToiDa;
        this.diaChi = diaChi;
        this.thuDi = thuDi;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public HocPhan getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(HocPhan maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public PhanCongGiangDay getMaPC() {
        return maPC;
    }

    public void setMaPC(PhanCongGiangDay maPC) {
        this.maPC = maPC;
    }

    public int getSoLuongToiDa() {
        return soLuongToiDa;
    }

    public void setSoLuongToiDa(int soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThuDi() {
        return thuDi;
    }

    public void setThuDi(String thuDi) {
        this.thuDi = thuDi;
    }

    public Integer getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(Integer tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public Integer getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(Integer soTiet) {
        this.soTiet = soTiet;
    }
}