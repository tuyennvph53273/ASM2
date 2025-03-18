package com.asm2.Serive.NhanVienSer;

import com.asm2.Entity.NhanVien.NhanVien;
import com.asm2.Repository.NhanVienRepo.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVIenSer {

    @Autowired
    private NhanVienRepo nhRepo;
    @Autowired
    private NhanVienRepo nhanVienRepo;

    public List<NhanVien>  getNhanVien(){
        return nhRepo.findAll();
    }

    public List<NhanVien> getNhanVienDangLamViec() {
        Boolean trangThaiBool = true;
        return nhRepo.findByTrangThai(trangThaiBool);

    }
    public NhanVien getNhanVienById(Long id){
        return nhRepo.findById(id).get();
    }

    public NhanVien findByTen(String ten) {
        return nhanVienRepo.findByTen(ten);
    }
    public void save(NhanVien nh){
        nhRepo.save(nh);
    }

    public void delete(Long id){
        nhRepo.deleteById(id);
    }

    public void update(NhanVien nh){
        if(nhRepo.existsById(nh.getId())){
            nhRepo.save(nh);
        }
    }

}
