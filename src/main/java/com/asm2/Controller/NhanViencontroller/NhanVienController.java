package com.asm2.Controller.NhanViencontroller;

import com.asm2.Entity.ChucVu.ChucVu;
import com.asm2.Entity.CuaHang.CuaHang;
import com.asm2.Entity.NhanVien.NhanVien;
import com.asm2.Serive.ChucVuSer.ChucVuSer;
import com.asm2.Serive.CuaHangSer.CuaHangSer;
import com.asm2.Serive.NhanVienSer.NhanVIenSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVIenSer nhanVIenSer;

    @Autowired
    private CuaHangSer cuaHangSer;

    @Autowired
    private ChucVuSer chucVuSer;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {

        model.addAttribute("nhanVienList",nhanVIenSer.getNhanVien());
        model.addAttribute("ch", cuaHangSer.getCuaHang());
        model.addAttribute("cv", chucVuSer.getChucVus());
        return "/View/BanHang/NhanVien/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        var nhanVien = nhanVIenSer.getNhanVienById(id);

        model.addAttribute("nvs", nhanVien);
        model.addAttribute("nhanVienList", nhanVIenSer.getNhanVien());
        model.addAttribute("ch", cuaHangSer.getCuaHang());
        model.addAttribute("cv", chucVuSer.getChucVus());

        model.addAttribute("selectedCuaHang", nhanVien.getCuaHang() != null ? nhanVien.getCuaHang().getId() : null);
        model.addAttribute("selectedChucVu", nhanVien.getChucVu() != null ? nhanVien.getChucVu().getId() : null);


        return "/View/BanHang/NhanVien/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        nhanVIenSer.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id, Model model) {
        var nhanVien = nhanVIenSer.getNhanVienById(id);

        model.addAttribute("nvs", nhanVien);
        model.addAttribute("nhanVienList", nhanVIenSer.getNhanVien());
        model.addAttribute("ch", cuaHangSer.getCuaHang());
        model.addAttribute("cv", chucVuSer.getChucVus());

        model.addAttribute("selectedCuaHang", nhanVien.getCuaHang() != null ? nhanVien.getCuaHang().getId() : null);
        model.addAttribute("selectedChucVu", nhanVien.getChucVu() != null ? nhanVien.getChucVu().getId() : null);

        return "/View/BanHang/NhanVien/update";
    }

    @PostMapping("add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            @RequestParam("tenDem")String tenDem,
            @RequestParam("ho")String ho,
            @RequestParam("gioiTinh")String gioiTinh,
            @RequestParam("ngaySinh") String ngaySinh,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("sdt") Integer sdt,
            @RequestParam("matKhau") String matKhau,
            @RequestParam("tenCH") Long ChIc,
            @RequestParam("tenCV")Long CvId,
            @RequestParam("trangThai") Boolean trangThai
          ) {
        CuaHang cuaHang = cuaHangSer.getCuaHangById(ChIc);
        ChucVu chucVu = chucVuSer.getChucVuById(CvId);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        nhanVien.setTenDem(tenDem);
        nhanVien.setHo(ho);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setDiaChi(diaChi);
        nhanVien.setSdt(sdt);
        nhanVien.setMatKhau(matKhau);
        nhanVien.setCuaHang(cuaHang);
        nhanVien.setChucVu(chucVu);
        nhanVien.setTrangThai(trangThai);
        nhanVIenSer.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            @RequestParam("tenDem")String tenDem,
            @RequestParam("ho")String ho,
            @RequestParam("gioiTinh")String gioiTinh,
            @RequestParam("ngaySinh") String ngaySinh,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("sdt") Integer sdt,
            @RequestParam("matKhau") String matKhau,
            @RequestParam("tenCH") Long ChIc,
            @RequestParam("tenCV")Long CvId,
            @RequestParam("trangThai") Boolean trangThai
    ) {
        CuaHang cuaHang = cuaHangSer.getCuaHangById(ChIc);
        ChucVu chucVu = chucVuSer.getChucVuById(CvId);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(id);
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        nhanVien.setTenDem(tenDem);
        nhanVien.setHo(ho);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setDiaChi(diaChi);
        nhanVien.setSdt(sdt);
        nhanVien.setMatKhau(matKhau);
        nhanVien.setCuaHang(cuaHang);
        nhanVien.setChucVu(chucVu);
        nhanVien.setTrangThai(trangThai);
        nhanVIenSer.update(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
