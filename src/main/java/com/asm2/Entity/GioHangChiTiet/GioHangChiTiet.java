package com.asm2.Entity.GioHangChiTiet;

import com.asm2.Entity.GioHang.GioiHang;
import com.asm2.Entity.SanPham.SanPham;
import com.asm2.Entity.SanPhamChiTiet.SanPhanChiTiet;
import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Integer donGia;

    @Column(name = "DonGiaKhiGiam")
    private Integer donGiaKhiGiam;

    @ManyToOne
    @MapsId("IdGioHang")
    @JoinColumn(name = "IdGioHang",referencedColumnName = "id")
    private GioiHang gioHang;

    @ManyToOne
    @MapsId("IdChiTietSP")
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "id")
    private SanPhanChiTiet sanPhanChiTiet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public Integer getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Integer donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioiHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioiHang gioHang) {
        this.gioHang = gioHang;
    }

    public SanPhanChiTiet getSanPhanChiTiet() {
        return sanPhanChiTiet;
    }

    public void setSanPhanChiTiet(SanPhanChiTiet sanPhanChiTiet) {
        this.sanPhanChiTiet = sanPhanChiTiet;
    }

    public GioHangChiTiet(Long id, Integer soLuong, Integer donGia, Integer donGiaKhiGiam, GioiHang gioHang, SanPhanChiTiet sanPhanChiTiet) {
        this.id = id;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.gioHang = gioHang;
        this.sanPhanChiTiet = sanPhanChiTiet;
    }

    public GioHangChiTiet() {
    }
}
