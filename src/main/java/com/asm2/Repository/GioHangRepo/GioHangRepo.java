package com.asm2.Repository.GioHangRepo;

import com.asm2.Entity.GioHang.GioiHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangRepo extends JpaRepository<GioiHang,Long> {
}
