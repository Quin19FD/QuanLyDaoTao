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
    @NotNull
    @Min(0)
    private int lyThuyet;

    @Column(name = "thuchanh")
    @NotNull
    @Min(0)
    private int thucHanh;

    @Column(name = "thuctap")
    @NotNull
    @Min(0)
    private int thucTap;

    public CTHocPhan() {}

    public CTHocPhan(HocPhan maHocPhan, int lyThuyet, int thucHanh, int thucTap) {
        this.maHocPhan = maHocPhan;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
        this.thucTap = thucTap;
    }

    public String getMaHocPhanId() {
        return maHocPhanId;
    }

    // Không nên để setter này, hoặc nếu có thì không dùng
    public void setMaHocPhanId(String maHocPhanId) {
        // BỎ TRỐNG hoặc xoá method này
    }

    public HocPhan getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(HocPhan maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public int getLyThuyet() {
        return lyThuyet;
    }

    public void setLyThuyet(int lyThuyet) {
        this.lyThuyet = lyThuyet;
    }

    public int getThucHanh() {
        return thucHanh;
    }

    public void setThucHanh(int thucHanh) {
        this.thucHanh = thucHanh;
    }

    public int getThucTap() {
        return thucTap;
    }

    public void setThucTap(int thucTap) {
        this.thucTap = thucTap;
    }

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
