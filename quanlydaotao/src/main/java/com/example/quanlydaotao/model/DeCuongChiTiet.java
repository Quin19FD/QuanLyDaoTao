package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "decuongchitiet")
public class DeCuongChiTiet {

    @Id
    @Column(name = "mabophan")
    private String maBoPhan;

    @ManyToOne
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    private HocPhan maHocPhan;

    @Column(name = "tenbophan")
    @NotNull(message = "Tên bộ phận không được để trống!")
    private String tenBoPhan;

    public DeCuongChiTiet() {}

    public DeCuongChiTiet(String maBoPhan, HocPhan maHocPhan, String tenBoPhan) {
        this.maHocPhan = maHocPhan;
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public HocPhan getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(HocPhan maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
