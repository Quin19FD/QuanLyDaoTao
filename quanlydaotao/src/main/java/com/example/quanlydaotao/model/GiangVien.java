package com.example.quanlydaotao.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "giangvien")
public class GiangVien {
    @Id
    @Column(name = "magv", nullable = false)
    private  int maGV;

    @Column(name = "tengv")
    @NotNull(message = "Tên giảng viên không được để trống!")
    private String tenGV;

    @Column(name = "namsinh")
    @NotNull(message = "Năm sinh không được để trống!")
    private String namSinh;

    @Column(name = "hocvi")
    @NotNull(message = "Học vị không được để trống!")
    private String hocVi;

    @Column(name = "congtackhac")
    private String congTacKhac;

    @Column(name = "tongCLC")
    @NotNull(message = "Tổng CLC không được để trống!")
    @Min(value = 0, message = "Tổng CLC không được âm!")
    private  int tongCLC;

    public  GiangVien(){
    }

    public GiangVien(int maGV, String tenGV, String namSinh, String hocVi, String congTacKhac, int tongCLC){
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.namSinh = namSinh;
        this.hocVi = hocVi;
        this.congTacKhac = congTacKhac;
        this.tongCLC = tongCLC;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getCongTacKhac() {
        return congTacKhac;
    }

    public void setCongTacKhac(String congTacKhac) {
        this.congTacKhac = congTacKhac;
    }

    public int getTongCLC() {
        return tongCLC;
    }

    public void setTongCLC(int tongCLC) {
        this.tongCLC = tongCLC;
    }
}
