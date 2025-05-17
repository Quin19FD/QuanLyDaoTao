package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "cthocphan")
public class CTHocPhan {

    @Id
    @Column(name = "mahocphan")
    private String maHocPhanId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    private HocPhan maHocPhan;

    @Column(name = "lythuyet")
    @NotNull(message = "Lý thuyết không được để trống!")
    @Min(value = 0, message = "Lý thuyết không được âm!")
    private int lyThuyet;

    @Column(name = "thuchanh")
    @NotNull(message = "Thực hành không được để trống!")
    @Min(value = 0, message = "Thực hành không được âm!")
    private int thucHanh;

    @Column(name = "thuctap")
    @NotNull(message = "Thực tập không được để trống!")
    @Min(value = 0, message = "Thực tập không được âm!")
    private int thucTap;

    public CTHocPhan() {}

    public CTHocPhan(HocPhan maHocPhan, int lyThuyet, int thucHanh, int thucTap) {
        this.maHocPhan = maHocPhan;
        this.maHocPhanId = maHocPhan != null ? maHocPhan.getMaHocPhan() : null;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
        this.thucTap = thucTap;
    }

    public String getMaHocPhanId() {
        return maHocPhanId;
    }

    public void setMaHocPhanId(String maHocPhanId) {
        this.maHocPhanId = maHocPhanId;
    }

    public HocPhan getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(HocPhan maHocPhan) {
        this.maHocPhan = maHocPhan;
        this.maHocPhanId = maHocPhan != null ? maHocPhan.getMaHocPhan() : null;
    }

    public int getLyThuyet() { return lyThuyet; }
    public void setLyThuyet(int lyThuyet) { this.lyThuyet = lyThuyet; }

    public int getThucHanh() { return thucHanh; }
    public void setThucHanh(int thucHanh) { this.thucHanh = thucHanh; }

    public int getThucTap() { return thucTap; }
    public void setThucTap(int thucTap) { this.thucTap = thucTap; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTHocPhan)) return false;
        CTHocPhan that = (CTHocPhan) o;
        return Objects.equals(maHocPhanId, that.maHocPhanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHocPhanId);
    }
}
