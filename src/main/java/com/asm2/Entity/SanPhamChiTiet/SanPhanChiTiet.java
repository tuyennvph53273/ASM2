package com.asm2.Entity.SanPhamChiTiet;

import com.asm2.Entity.ChucVu.ChucVu;
import com.asm2.Entity.DongSP.DongSP;
import com.asm2.Entity.MauSac.MauSac;
import com.asm2.Entity.NSX.NSX;
import com.asm2.Entity.SanPham.SanPham;
import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietSP")
public class SanPhanChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Integer giaNhap;

    @Column(name = "GiaBan")
    private Integer giaBan;

    @ManyToOne
    @JoinColumn(name = "IdSP",referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx",referencedColumnName = "id")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",referencedColumnName = "id")
    private DongSP dongSP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Integer getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Integer giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public SanPhanChiTiet(Long id, Integer namBH, String moTa, Integer soLuongTon, Integer giaNhap, Integer giaBan, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP) {
        this.id = id;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
    }

    public SanPhanChiTiet() {
    }
}
