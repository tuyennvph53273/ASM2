package com.asm2.Serive.MauSac;

import com.asm2.Entity.MauSac.MauSac;
import com.asm2.Repository.MauSac.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacSer {
    @Autowired
    private MauSacRepo mauSacRepo;

    public List<MauSac> getMauSac() {
        return mauSacRepo.findAll();
    }

    public MauSac getMauSacByid(Long id ) {
        return mauSacRepo.findById(id).get();
    }
    public void addMauSac(MauSac mauSac) {
        mauSacRepo.save(mauSac);
    }
    public void updateMauSac(MauSac mauSac) {
        if (mauSacRepo.existsById(mauSac.getId())) {
            mauSacRepo.save(mauSac);
        } else {
            throw new IllegalArgumentException("Mầu sắc không tồn tại!");
        }
    }
    public void deleteMauSac(Long id) {
        mauSacRepo.deleteById(id);
    }
}
