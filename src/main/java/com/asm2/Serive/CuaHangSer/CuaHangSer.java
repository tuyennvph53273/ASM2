package com.asm2.Serive.CuaHangSer;

import com.asm2.Entity.CuaHang.CuaHang;
import com.asm2.Repository.CuaHangRepo.CuaHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangSer {
    @Autowired
    private CuaHangRepo cuaHangRepo;
    public List<CuaHang> getCuaHang() {
        return cuaHangRepo.findAll();
    }

    public CuaHang getCuaHangById(Long id) {
        return cuaHangRepo.findById(id).get();
    }

    public void save(CuaHang cuaHang) {
        cuaHangRepo.save(cuaHang);
    }

    public void update(CuaHang cuaHang) {
        if (cuaHangRepo.existsById(cuaHang.getId())) {
            cuaHangRepo.save(cuaHang);
        } else {
            throw new IllegalArgumentException("Cửa hàng không tồn tại!");
        }
    }

    public void delete(Long ma ) {
        cuaHangRepo.deleteById(ma);

    }
}
