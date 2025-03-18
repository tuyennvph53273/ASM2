package com.asm2.Controller.BanHangController;

import com.asm2.Entity.GioHang.GioiHang;
import com.asm2.Entity.GioHangChiTiet.GioHangChiTiet;
import com.asm2.Serive.GioHangChiTietSer.GioHangChiTietSer;
import com.asm2.Serive.GioHangSer.GioiHangSer;
import com.asm2.Serive.NhanVienSer.NhanVIenSer;
import com.asm2.Serive.SanPhamChiTietSer.SanPhanChiTietSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class BanHangController {
        @Autowired
        private GioiHangSer gioiHangSer;

        @Autowired
        private GioHangChiTietSer gioHangChiTietSer;

        @Autowired
        private SanPhanChiTietSer sanPhanChiTietSer;

        @Autowired
        private NhanVIenSer nhanVIenSer;


    @GetMapping("/ban-hang/hien-thi")
    public String banHang(Model model) {
        model.addAttribute("gioHangList", gioiHangSer.getGioHang());
        model.addAttribute("sanPhamCTList", sanPhanChiTietSer.GetAll());
        model.addAttribute("nhanVienList", nhanVIenSer.getNhanVienDangLamViec());
        return "/View/BanHang/Ban_Hang";
    }
    @GetMapping("/gio-hang/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        gioiHangSer.delete(id);
        return "redirect:/ban-hang/hien-thi";
    }

    @GetMapping("/gio-hang/detailGHCT/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("gioHangList", gioiHangSer.getGioHang());
        model.addAttribute("sanPhamCTList", sanPhanChiTietSer.GetAll());
        model.addAttribute("nhanVienList", nhanVIenSer.getNhanVienDangLamViec());
        model.addAttribute("gioHangCTList", gioHangChiTietSer.getGioHangChiTietByGioHangId(id));
//        GioHangChiTiet ghct = new GioHangChiTiet();
//        ghct.setGioHang(generateGioHangCTCode());
//        gioHangChiTietSer.addGHCT(ghct);
        return "/View/BanHang/Ban_Hang";
    }

//    public GioHangChiTiet generateGioHangCTCode() {
//        Long count = gioiHangSer.getGioHang().stream().count();
//        long newId = count + 1;
//        return String.format("", newId);
//    }
    public String generateGioHangCode() {
        Long count = gioiHangSer.getGioHang().stream().count();
        long newId = count + 1;
        return String.format("GH%02d", newId);
    }


    @PostMapping("/gio-hang/add")
    public String createGioHang(@RequestParam("nvID") Long nhanVienId) {
        GioiHang gioHang = new GioiHang();
        gioHang.setMa(generateGioHangCode());
        gioHang.setKhachHang(null);
        gioHang.setNhanVien(nhanVIenSer.getNhanVienById(nhanVienId));
        gioHang.setNgayTao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        gioHang.setTinhTrang(false);
        GioiHang add = gioiHangSer.add(gioHang);

        return "redirect:/ban-hang/hien-thi";
    }



}
