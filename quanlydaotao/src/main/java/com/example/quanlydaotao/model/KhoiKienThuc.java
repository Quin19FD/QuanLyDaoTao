
package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "khoikienthuc")
public class KhoiKienThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhoikienthuc")
    private int maKhoiKienThuc;

    @ManyToOne
    @JoinColumn(name = "makhung", referencedColumnName = "makhung", nullable = false)
    private CTKhung maKhung;

    @Column(name = "kienthuc")
    @NotNull(message = "Kiến thức không được để trống!")
    private String kienThuc;

    @Column(name = "tinbatbuoc")
    @NotNull(message = "Tín chỉ bắt buộc không được để trống!")
    @Min(value = 0, message = "Tín chỉ bắt buộc không được âm!")
    private int tinChiBatBuoc;

    @Column(name = "tintuchon")
    @NotNull(message = "Tín chỉ tự chọn không được để trống!")
    @Min(value = 0, message = "Tín chỉ tự chọn không được âm!")
    private int tinChiTuChon;

    public KhoiKienThuc() {}

    public KhoiKienThuc(int maKhoiKienThuc, CTKhung maKhung, String kienThuc, int tinChiBatBuoc, int tinChiTuChon) {
        this.maKhoiKienThuc = maKhoiKienThuc;
        this.maKhung = maKhung;
        this.kienThuc = kienThuc;
        this.tinChiBatBuoc = tinChiBatBuoc;
        this.tinChiTuChon = tinChiTuChon;
    }

    public int getMaKhoiKienThuc() {
        return maKhoiKienThuc;
    }

    public void setMaKhoiKienThuc(int maKhoiKienThuc) {
        this.maKhoiKienThuc = maKhoiKienThuc;
    }

    public CTKhung getMaKhoi() {
        return maKhung;
    }

    public void setMaKhoi(CTKhung maKhung) {
        this.maKhung = maKhung;
    }

    public String getKienThuc() {
        return kienThuc;
    }

    public void setKienThuc(String kienThuc) {
        this.kienThuc = kienThuc;
    }

    public int getTinChiBatBuoc() {
        return tinChiBatBuoc;
    }

    public void setTinChiBatBuoc(int tinChiBatBuoc) {
        this.tinChiBatBuoc = tinChiBatBuoc;
    }

    public int getTinChiTuChon() {
        return tinChiTuChon;
    }

    public void setTinChiTuChon(int tinChiTuChon) {
        this.tinChiTuChon = tinChiTuChon;
    }
}
