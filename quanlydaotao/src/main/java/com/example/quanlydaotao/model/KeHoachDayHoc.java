package com.example.quanlydaotao.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "kehoachdayhoc")
public class KeHoachDayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makehoach")
    private int maKeHoach;

    @ManyToOne
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    private HocPhan maHocPhan;

    @ManyToOne
    @JoinColumn(name = "mapc", referencedColumnName = "mapc", nullable = false)
    private PhanCongGiangDay maPC;

    @Column(name = "hockythuchien")
    @NotNull(message = "Học kỳ thực hiện không được để trống!")
    @Min(value = 0, message = "Học kỳ thực hiện không được âm!")
    private int hocKyThucHien;

    @OneToOne
    @JoinColumn(name = "mahocphantruoc", referencedColumnName = "mahocphan", nullable = true)
    private HocPhan maHocPhanTruoc;

    public KeHoachDayHoc(){
    }

    public KeHoachDayHoc(int maKeHoach, HocPhan maHocPhan, PhanCongGiangDay maPC, int hocKyThucHien, HocPhan maHocPhanTruoc){
        this.maKeHoach = maKeHoach;
        this.maHocPhan = maHocPhan;
        this.maPC = maPC;
        this.hocKyThucHien = hocKyThucHien;
        this.maHocPhanTruoc = maHocPhanTruoc;
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

    public int getHocKyThucHien() {
        return hocKyThucHien;
    }

    public void setHocKyThucHien(int hocKyThucHien) {
        this.hocKyThucHien = hocKyThucHien;
    }

    public HocPhan getMaHocPhanTruoc() {
        return maHocPhanTruoc;
    }

    public void setMaHocPhanTruoc(HocPhan maHocPhanTruoc) {
        this.maHocPhanTruoc = maHocPhanTruoc;
    }
}
