package com.asm2.Repository.SanPhamRepo;

import com.asm2.Entity.SanPham.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepo extends JpaRepository<SanPham, Long> {
}
