package com.asm2.Serive.ChucVuSer;

import com.asm2.Entity.ChucVu.ChucVu;
import com.asm2.Repository.ChucVuRepo.ChucVuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuSer {

    @Autowired
    private ChucVuRepo chucVuRepo;

    public List<ChucVu> getChucVus() {
        return chucVuRepo.findAll();
    }

    public ChucVu getChucVuById(Long id ) {
        return chucVuRepo.findById(id).get();
    }

    public void add(ChucVu chucVu) {
        chucVuRepo.save(chucVu);
    }
    public void update(ChucVu chucVu) {
        if (chucVuRepo.existsById(chucVu.getId())) {
            chucVuRepo.save(chucVu);
        } else {
            throw new IllegalArgumentException("Chức vụ  không tồn tại!");
        }
    }

    public void delete(Long id ) {
        chucVuRepo.deleteById(id);
    }
}
