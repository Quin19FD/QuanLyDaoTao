package com.example.quanlydaotao.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "kehoachdayhoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KeHoachDayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makehoach")
    private int maKeHoach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private HocPhan maHocPhan;

    // Các trường khác không cần @JsonIgnoreProperties vì không load trong repository
    @Column(name = "hockythuchien")
    @NotNull(message = "Học kỳ thực hiện không được để trống!")
    private String hocKyThucHien;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahocphantruoc", referencedColumnName = "mahocphan")
    private HocPhan maHocPhanTruoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapc", nullable = true)
    private PhanCongGiangDay maPC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mactdt", nullable = true)
    private CTDaoTao mactdt;

    public KeHoachDayHoc(){
    }

    public KeHoachDayHoc(int maKeHoach, HocPhan maHocPhan, PhanCongGiangDay maPC, String hocKyThucHien, HocPhan maHocPhanTruoc, CTDaoTao mactdt){
        this.maKeHoach = maKeHoach;
        this.maHocPhan = maHocPhan;
        this.maPC = maPC;
        this.hocKyThucHien = hocKyThucHien;
        this.maHocPhanTruoc = maHocPhanTruoc;
        this.mactdt = mactdt;
    }

    public int getMaKeHoach() {
        return maKeHoach;
    }

    public void setMaKeHoach(int maKeHoach) {
        this.maKeHoach = maKeHoach;
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

    public String getHocKyThucHien() {
        return hocKyThucHien;
    }

    public void setHocKyThucHien(String hocKyThucHien) {
        this.hocKyThucHien = hocKyThucHien;
    }

    public HocPhan getMaHocPhanTruoc() {
        return maHocPhanTruoc;
    }

    public void setMaHocPhanTruoc(HocPhan maHocPhanTruoc) {
        this.maHocPhanTruoc = maHocPhanTruoc;
    }

    public CTDaoTao getMactdt() {
        return mactdt;
    }

    public void setMactdt(CTDaoTao mactdt) {
        this.mactdt = mactdt;
    }
}
