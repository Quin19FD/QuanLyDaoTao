package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cthocphan")
public class CTHocPhan {
    @Id
    @Column(name = "mahocphan")
    private String maHocPhan;

    @OneToOne
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", insertable = false, updatable = false)
    private HocPhan hocPhan;

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

    public CTHocPhan(String maHocPhan, int lyThuyet, int thucHanh, int thucTap) {
        this.maHocPhan = maHocPhan;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
        this.thucTap = thucTap;
    }

    public String getMaHocPhan() { return maHocPhan; }
    public void setMaHocPhan(String maHocPhan) { this.maHocPhan = maHocPhan; }

    public HocPhan getHocPhan() { return hocPhan; }
    public void setHocPhan(HocPhan hocPhan) { this.hocPhan = hocPhan; }
    public int getLyThuyet() { return lyThuyet; }
    public void setLyThuyet(int lyThuyet) { this.lyThuyet = lyThuyet; }
    public int getThucHanh() { return thucHanh; }
    public void setThucHanh(int thucHanh) { this.thucHanh = thucHanh; }
    public int getThucTap() { return thucTap; }
    public void setThucTap(int thucTap) { this.thucTap = thucTap; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CTHocPhan ctHocPhan = (CTHocPhan) o;

        return maHocPhan != null ? maHocPhan.equals(ctHocPhan.maHocPhan) : ctHocPhan.maHocPhan == null;
    }

    @Override
    public int hashCode() {
        return maHocPhan != null ? maHocPhan.hashCode() : 0;
    }
}