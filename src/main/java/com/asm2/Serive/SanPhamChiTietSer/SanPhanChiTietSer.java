package com.asm2.Serive.SanPhamChiTietSer;

import com.asm2.Entity.SanPhamChiTiet.SanPhanChiTiet;
import com.asm2.Repository.SanPhamChiTietReo.SanPhamChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhanChiTietSer {

    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;

    public List<SanPhanChiTiet> GetAll() {
        return sanPhamChiTietRepo.findAll();
    }

    public SanPhanChiTiet GetById(Long id) {
        return sanPhamChiTietRepo.findById(id).get();
    }

    public void Save(SanPhanChiTiet s) {
        sanPhamChiTietRepo.save(s);
    }

    public void delete(Long id) {
        sanPhamChiTietRepo.deleteById(id);
    }

    public void update(SanPhanChiTiet s) {
        if (sanPhamChiTietRepo.existsById(s.getId())) {
            sanPhamChiTietRepo.save(s);
        }
    }
}
