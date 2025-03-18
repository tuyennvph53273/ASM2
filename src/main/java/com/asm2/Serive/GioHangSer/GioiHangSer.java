package com.asm2.Serive.GioHangSer;

import com.asm2.Entity.GioHang.GioiHang;
import com.asm2.Repository.GioHangRepo.GioHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioiHangSer {

    @Autowired
    private GioHangRepo gioHangRepo;

    public List<GioiHang> getGioHang() {
        return gioHangRepo.findAll();
    }

    public GioiHang add(GioiHang gioHang) {
        return gioHangRepo.save(gioHang);
    }

    public void delete(Long id) {
        gioHangRepo.deleteById(id);
    }

    public GioiHang findById(Long id) {
        return gioHangRepo.findById(id).get();
    }

    public void update(GioiHang gioiHang) {
       if(gioHangRepo.existsById(gioiHang.getId())) {
           gioHangRepo.save(gioiHang);
       }
    }
}
