package com.asm2.Controller.SanPhamChiTietController;


import com.asm2.Entity.DongSP.DongSP;
import com.asm2.Entity.MauSac.MauSac;
import com.asm2.Entity.NSX.NSX;
import com.asm2.Entity.SanPham.SanPham;
import com.asm2.Entity.SanPhamChiTiet.SanPhanChiTiet;
import com.asm2.Serive.DongSpSer.DongSPSer;
import com.asm2.Serive.MauSac.MauSacSer;
import com.asm2.Serive.NsxSer.NsxSer;
import com.asm2.Serive.SanPhamChiTietSer.SanPhanChiTietSer;
import com.asm2.Serive.SanPhamSer.SanPhamSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sp-chi-tiet/")
public class SanPhamChiTietController {
    @Autowired
    private SanPhanChiTietSer sanPhanChiTietSer;

    @Autowired
    private SanPhamSer sanPhamSer;

    @Autowired
    private NsxSer nsxSer;

    @Autowired
    private MauSacSer mauSacSer;

    @Autowired
    private DongSPSer dongSPSer;

    @GetMapping("hien-thi")
    public String hien(Model model) {
        model.addAttribute("spctList",sanPhanChiTietSer.GetAll());
        model.addAttribute("sp",sanPhamSer.getfinds());
        model.addAttribute("nsx",nsxSer.findAll());
        model.addAttribute("ms",mauSacSer.getMauSac());
        model.addAttribute("ds",dongSPSer.getList());
       return "/View/BanHang/SanPhanChiTiet/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        sanPhanChiTietSer.delete(id);
        return "redirect:/sp-chi-tiet/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        SanPhanChiTiet ctsp = sanPhanChiTietSer.GetById(id);
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("spctList", sanPhanChiTietSer.GetAll());
        model.addAttribute("sp", sanPhamSer.getfinds());
        model.addAttribute("nsx", nsxSer.findAll());
        model.addAttribute("ms", mauSacSer.getMauSac());
        model.addAttribute("ds", dongSPSer.getList());
        return "/View/BanHang/SanPhanChiTiet/hien-thi";
    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ctsp", sanPhanChiTietSer.GetById(id));
        model.addAttribute("sp",sanPhamSer.getfinds());
        model.addAttribute("nsx",nsxSer.findAll());
        model.addAttribute("ms",mauSacSer.getMauSac());
        model.addAttribute("ds",dongSPSer.getList());

        return "/View/BanHang/SanPhanChiTiet/update";

    }

    @PostMapping("add")
    public String add(
            @RequestParam("tenSP") Long sanPhamId,
            @RequestParam("nsx") Long nsxId,
            @RequestParam("mauSac") Long mauSacId,
            @RequestParam("dongsp") Long dongSpId,
            @RequestParam("namBH") Integer namBH,
            @RequestParam("mota") String moTa,
            @RequestParam("soLuongTon") Integer soLuongTon,
            @RequestParam("giaNhap") Integer giaNhap,
            @RequestParam("giaBan") Integer giaBan
    ) {
        SanPham sanPham = sanPhamSer.getfindbyid(sanPhamId);
        NSX nsx = nsxSer.findById( nsxId);
        MauSac mauSac = mauSacSer.getMauSacByid(mauSacId);
        DongSP dongSP = dongSPSer.findById(dongSpId);

        SanPhanChiTiet spct = new SanPhanChiTiet();
        spct.setSanPham(sanPham);
        spct.setNsx(nsx);
        spct.setMauSac(mauSac);
        spct.setDongSP(dongSP);
        spct.setNamBH(namBH);
        spct.setMoTa(moTa);
        spct.setSoLuongTon(soLuongTon);
        spct.setGiaNhap(giaNhap);
        spct.setGiaBan(giaBan);

        sanPhanChiTietSer.Save(spct);
        return "redirect:/sp-chi-tiet/hien-thi";
    }

    @PostMapping("update")
    public String update(
            @RequestParam("id") Long Id,
            @RequestParam("tenSP") Long sanPhamId,
            @RequestParam("nsx") Long nsxId,
            @RequestParam("mauSac") Long mauSacId,
            @RequestParam("dongsp") Long dongSpId,
            @RequestParam("namBH") Integer namBH,
            @RequestParam("mota") String moTa,
            @RequestParam("soLuongTon") Integer soLuongTon,
            @RequestParam("giaNhap") Integer giaNhap,
            @RequestParam("giaBan") Integer giaBan
    ) {
        SanPham sanPham = sanPhamSer.getfindbyid(sanPhamId);
        NSX nsx = nsxSer.findById( nsxId);
        MauSac mauSac = mauSacSer.getMauSacByid(mauSacId);
        DongSP dongSP = dongSPSer.findById(dongSpId);

        SanPhanChiTiet spct = new SanPhanChiTiet();
        spct.setId(Id);
        spct.setSanPham(sanPham);
        spct.setNsx(nsx);
        spct.setMauSac(mauSac);
        spct.setDongSP(dongSP);
        spct.setNamBH(namBH);
        spct.setMoTa(moTa);
        spct.setSoLuongTon(soLuongTon);
        spct.setGiaNhap(giaNhap);
        spct.setGiaBan(giaBan);

        sanPhanChiTietSer.update(spct);
        return "redirect:/sp-chi-tiet/hien-thi";
    }
}
