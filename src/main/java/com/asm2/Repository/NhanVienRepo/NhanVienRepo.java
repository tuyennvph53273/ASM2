package com.asm2.Repository.NhanVienRepo;

import com.asm2.Entity.NhanVien.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanVienRepo extends JpaRepository<NhanVien, Long> {

    List<NhanVien> findByTrangThai(Boolean trangThai);

    NhanVien findByTen(String ten);
}
