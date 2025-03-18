package com.asm2.Controller.SanPhamController;

import com.asm2.Entity.NSX.NSX;
import com.asm2.Entity.SanPham.SanPham;
import com.asm2.Serive.SanPhamSer.SanPhamSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamSer sanPhamSer;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("sanPhamList",sanPhamSer.getfinds());
        return "/View/BanHang/SanPham/hien-thi";
    }

    @PostMapping("add")
    public String addMauSac(SanPham sanPham) {
        sanPhamSer.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
    @PostMapping("update")
    public String editMauSac(SanPham sanPham) {
        sanPhamSer.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String detailMauSac(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("sp",sanPhamSer.getfindbyid(id));
        model.addAttribute("sanPhamList", sanPhamSer.getfinds());
        return "/View/BanHang/SanPham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deletevMauSac(@PathVariable("id") Long id) {
        sanPhamSer.delete(id);
        return "redirect:/san-pham/hien-thi";

    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id , Model model) {
        model.addAttribute("sp",sanPhamSer.getfindbyid(id));
        return "/View/BanHang/SanPham/update";

    }
}
