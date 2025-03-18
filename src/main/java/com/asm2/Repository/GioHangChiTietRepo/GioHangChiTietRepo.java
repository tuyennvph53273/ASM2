package com.asm2.Repository.GioHangChiTietRepo;

import com.asm2.Entity.GioHangChiTiet.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangChiTietRepo extends JpaRepository<GioHangChiTiet , Long> {
    @Query("SELECT ghct FROM GioHangChiTiet ghct WHERE ghct.gioHang.id = :gioHangId")
    List<GioHangChiTiet> findByGioHangId(@Param("gioHangId") Long gioHangId);
}
