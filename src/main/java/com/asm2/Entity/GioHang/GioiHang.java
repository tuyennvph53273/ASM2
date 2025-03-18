package com.asm2.Entity.GioHang;

import com.asm2.Entity.KhachHang.KhachHang;
import com.asm2.Entity.NhanVien.NhanVien;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "GioHang")
public class GioiHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Boolean tinhTrang;

    @ManyToOne
    @JoinColumn(name = "IdKH", referencedColumnName = "id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "id")
    private NhanVien  nhanVien;

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }
    public GioiHang(Long id, String ma, String ngayTao, String ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, Boolean tinhTrang, KhachHang khachHang, NhanVien nhanVien) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
    }


    @Override
    public String toString() {
        return "GioiHang{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngayThanhToan='" + ngayThanhToan + '\'' +
                ", tenNguoiNhan='" + tenNguoiNhan + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", tinhTrang=" + tinhTrang +
                ", khachHang=" + khachHang +
                ", nhanVien=" + nhanVien +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public GioiHang() {
    }
}
