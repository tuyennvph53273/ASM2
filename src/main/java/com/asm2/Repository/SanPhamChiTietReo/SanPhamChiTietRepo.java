package com.asm2.Repository.SanPhamChiTietReo;

import com.asm2.Entity.SanPhamChiTiet.SanPhanChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamChiTietRepo extends JpaRepository<SanPhanChiTiet , Long > {
}
