package com.asm2.Serive.GioHangChiTietSer;

import com.asm2.Entity.GioHang.GioiHang;
import com.asm2.Entity.GioHangChiTiet.GioHangChiTiet;
import com.asm2.Repository.GioHangChiTietRepo.GioHangChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietSer {

    @Autowired
    private GioHangChiTietRepo gioHangChiTietRepo;

    public List<GioHangChiTiet> getGioHangChiTiet() {
        return gioHangChiTietRepo.findAll();
    }

    public GioHangChiTiet getGioHangTCById(Long id ) {
        return gioHangChiTietRepo.findById(id).get();
    }

    public List<GioHangChiTiet> getGioHangChiTietByGioHangId(Long gioHangId) {
        return gioHangChiTietRepo.findByGioHangId(gioHangId);
    }

    public void addGHCT(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepo.save(gioHangChiTiet);
    }
}
