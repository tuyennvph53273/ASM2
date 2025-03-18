package com.asm2.Repository.CuaHangRepo;

import com.asm2.Entity.CuaHang.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepo extends JpaRepository<CuaHang, Long> {
    void deleteByMa(String ma);
}
