package com.asm2.Serive.SanPhamSer;

import com.asm2.Entity.SanPham.SanPham;
import com.asm2.Repository.SanPhamRepo.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamSer {
    @Autowired
    private SanPhamRepo sanPhamRepo;

    public List<SanPham> getfinds(){
     return     sanPhamRepo.findAll();
    }
    public SanPham getfindbyid(Long id) {
        return sanPhamRepo.findById(id).get();
    }

    public void save(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
    }
    public void delete(Long id ) {
        sanPhamRepo.deleteById(id);
    }

    public void update(SanPham sanPham) {
        if (sanPhamRepo.existsById(sanPham.getId())) {
            sanPhamRepo.save(sanPham);
        }
    }
}
