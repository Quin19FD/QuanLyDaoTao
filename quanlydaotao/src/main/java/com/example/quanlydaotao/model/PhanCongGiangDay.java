package com.example.quanlydaotao.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "phanconggiangday")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhanCongGiangDay {
    @Id
    @Column(name = "mapc", nullable = false)
    private int maPC;

    @Column(name = "khoahoc")
    @NotNull(message = "Khóa học không được để trống!")
    private String khoaHoc;

    @Column(name = "hesohocphan")
    @NotNull(message = "Hệ số học phần không được để trống!")
    @Min(value = 0, message = "Hệ số học phần không được âm!")
    private float heSoHP;

    @Column(name = "tongsonhom")
    @NotNull(message = "Trọng số không được để trống!")
    @Min(value = 0, message = "Trọng số không được âm!")
    private int tongSoNhom;

    @Column(name = "slsvmotnhom")
    @NotNull(message = "Tổng số nhóm không được để trống!")
    @Min(value = 0, message = "Tổng số nhóm không được âm!")
    private int slSVMotNhom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magv", referencedColumnName = "magv", nullable = false)
    @JsonIgnoreProperties({"ngaySinh", "gioiTinh", "hocVi", "chuyenNganh", "sdt", "email"})
    @NotNull(message = "Mã giảng viên không được để trống!")
    private GiangVien maGV;

    @Column(name = "sotietthucte")
    @NotNull(message = "Số tiết thực tế không được để trống!")
    @Min(value = 0, message = "Số tiết thực tế không được âm!")
    private int soTietThucTe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    @JsonIgnoreProperties({"maDaoTao", "maKhoiKienThuc", "maChuyenNganh", "heSo"})
    private HocPhan maHocPhan;

    public PhanCongGiangDay(){
    }

    public PhanCongGiangDay(int maPC, String khoaHoc, float heSoHP, int tongSoNhom,
                            int slSVMotNhom, GiangVien maGV, int soTietThucTe, HocPhan maHocPhan){
        this.maPC = maPC;
        this.khoaHoc = khoaHoc;
        this.heSoHP = heSoHP;
        this.tongSoNhom = tongSoNhom;
        this.slSVMotNhom = slSVMotNhom;
        this.maGV = maGV;
        this.soTietThucTe = soTietThucTe;
        this.maHocPhan = maHocPhan;
    }

    public int getMaPC() {
        return maPC;
    }

    public void setMaPC(int maPC) {
        this.maPC = maPC;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public float getHeSoHP() {
        return heSoHP;
    }

    public void setHeSoHP(float heSoHP) {
        this.heSoHP = heSoHP;
    }

    public int getTongSoNhom() {
        return tongSoNhom;
    }

    public void setTongSoNhom(int tongSoNhom) {
        this.tongSoNhom = tongSoNhom;
    }

    public int getSlSVMotNhom() {
        return slSVMotNhom;
    }

    public void setSlSVMotNhom(int slSVMotNhom) {
        this.slSVMotNhom = slSVMotNhom;
    }

    public GiangVien getMaGV() {
        return maGV;
    }

    public void setMaGV(GiangVien maGV) {
        this.maGV = maGV;
    }

    public int getSoTietThucTe() {
        return soTietThucTe;
    }

    public void setSoTietThucTe(int soTietThucTe) {
        this.soTietThucTe = soTietThucTe;
    }

    public HocPhan getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(HocPhan maHocPhan) {
        this.maHocPhan = maHocPhan;
    }
}
