package com.asm2.Entity.Login;

import com.asm2.Entity.ChucVu.ChucVu;
import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MatKhau")
     private String matkhau;

    @Column(name = "TrangThai")
    private Integer trangThai;


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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Login(Long id, String ma, String ten, String matkhau, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.matkhau = matkhau;
        this.trangThai = trangThai;
    }

    public Login() {
    }
}