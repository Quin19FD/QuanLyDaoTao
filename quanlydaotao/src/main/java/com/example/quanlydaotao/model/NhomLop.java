
package com.example.quanlydaotao.model;
import jakarta.persistence.*;

@Entity
@Table(name = "nhomlop")
public class NhomLop {
    @Id
    @Column(name = "manhom", nullable = false)
    private int maNhom;

    @ManyToOne
    @JoinColumn(name = "mahocphan", referencedColumnName = "mahocphan", nullable = false)
    private HocPhan maHocPhan;

    @ManyToOne
    @JoinColumn(name = "mapc", referencedColumnName = "mapc", nullable = false)
    private PhanCongGiangDay maPC;

    public NhomLop(){
    }

    public NhomLop(int maNhom, HocPhan maHocPhan, PhanCongGiangDay maPC){
        this.maNhom = maNhom;
        this.maHocPhan = maHocPhan;
        this.maPC = maPC;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
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
}
