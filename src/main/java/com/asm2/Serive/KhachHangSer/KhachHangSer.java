package com.asm2.Serive.KhachHangSer;

import com.asm2.Entity.KhachHang.KhachHang;
import com.asm2.Repository.KhachHangRepo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangSer {
    @Autowired
    private KhachHangRepo khachHangRepo;

    public List<KhachHang> getKhachHang() {
        return khachHangRepo.findAll();
    }

    public void save(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    public void delete(Long id ) {
        khachHangRepo.deleteById(id);
    }

    public void update( KhachHang khachHang) {
        if (khachHangRepo.existsById(khachHang.getId())) {
            khachHangRepo.save(khachHang);
        }
    }
    public KhachHang getKhachHangById(Long id) {
        return khachHangRepo.findById(id).get();
    }
}
