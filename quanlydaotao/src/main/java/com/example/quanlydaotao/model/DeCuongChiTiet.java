package com.example.quanlydaotao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "decuongchitiet")
public class DeCuongChiTiet {

    @Id
    @Column(name = "mabophan")
    private String maBoPhan;

    @Column(name = "tenbophan")
    @NotNull(message = "Tên bộ phận không được để trống!")
    private String tenBoPhan;

    @ManyToOne
    @JoinColumn(name = "mactdt", referencedColumnName = "mactdt", nullable = false)
    private CTDaoTao ctdt;

    public DeCuongChiTiet() {}

    public DeCuongChiTiet(String maBoPhan, String tenBoPhan, CTDaoTao mactdt) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.ctdt = mactdt;
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

    public CTDaoTao getCtdt() {
        return ctdt;
    }

    public void setCtdt(CTDaoTao ctdt) {
        this.ctdt = ctdt;
    }
}
