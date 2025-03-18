package com.asm2.Serive.DongSpSer;

import com.asm2.Entity.DongSP.DongSP;
import com.asm2.Entity.NSX.NSX;
import com.asm2.Repository.DongSPRepo.DongSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSPSer {
    @Autowired
    private DongSpRepo dongSpRepo;

    public List<DongSP> getList() {
        return dongSpRepo.findAll();
    }


    public DongSP findById(Long id) {
        return dongSpRepo.findById(id).get();
    }

    public void save(DongSP dongSP) {
        dongSpRepo.save(dongSP);
    }
    public void delete(Long id ) {
        dongSpRepo.deleteById(id);
    }
    public void update(DongSP dongSP) {
        if (dongSpRepo.existsById(dongSP.getId())) {
            dongSpRepo.save(dongSP);
        }
    }
}
