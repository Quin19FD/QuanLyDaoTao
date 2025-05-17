package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ctkhung")
public class CTKhung {
    @Id
    @Column(name = "makhung")
    private int maKhung;

    @ManyToOne
    @JoinColumn(name = "mactdt", referencedColumnName = "mactdt", nullable = false)
    @NotNull(message = "Mã chương trình đào tạo không được để trống")
    private CTDaoTao maCTDT;

    public CTKhung() {

    }

    public CTKhung(CTDaoTao maCTDT, int maKhung) {
        this.maCTDT = maCTDT;
        this.maKhung = maKhung;
    }

    public CTDaoTao getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(CTDaoTao maCTDT) {
        this.maCTDT = maCTDT;
    }

    public int getMaKhung() {
        return maKhung;
    }

    public void setMaKhung(int maKhung) {
        this.maKhung = maKhung;
    }

}
