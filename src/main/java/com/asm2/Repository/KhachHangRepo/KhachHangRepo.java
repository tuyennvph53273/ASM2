package com.asm2.Repository.KhachHangRepo;

import com.asm2.Entity.KhachHang.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {
}
