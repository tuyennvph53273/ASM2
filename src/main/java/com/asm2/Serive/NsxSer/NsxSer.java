package com.asm2.Serive.NsxSer;

import com.asm2.Entity.NSX.NSX;
import com.asm2.Repository.NsxREPO.NsxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxSer {

    @Autowired
    private NsxRepo nsxRepo;

    public List<NSX> findAll() {
        return nsxRepo.findAll();
    }

    public NSX findById(Long id) {
        return nsxRepo.findById(id).get();
    }

    public void save(NSX nsx) {
        nsxRepo.save(nsx);
    }
    public void delete(Long id ) {
        nsxRepo.deleteById(id);
    }
    public void update(NSX nsx) {
        if (nsxRepo.existsById(nsx.getId())) {
            nsxRepo.save(nsx);
        }
    }
}
