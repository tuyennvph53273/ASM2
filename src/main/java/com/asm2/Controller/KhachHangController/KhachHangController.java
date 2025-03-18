package com.asm2.Controller.KhachHangController;

import com.asm2.Entity.KhachHang.KhachHang;
import com.asm2.Serive.KhachHangSer.KhachHangSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khach-hang/")
public class KhachHangController {

    @Autowired
    private KhachHangSer khachHangSer;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("khachHangLists", khachHangSer.getKhachHang());
        return "/View/BanHang/KhachHang/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String hienThi( @PathVariable("id")Long id ,
                           Model model) {
        model.addAttribute("kh", khachHangSer.getKhachHangById(id));
        model.addAttribute("khachHangLists", khachHangSer.getKhachHang());
        return "/View/BanHang/KhachHang/hien-thi";
    }
    @GetMapping("delete/{id}")
    public String delete( @PathVariable("id")Long id ) {
      khachHangSer.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate( @PathVariable("id")Long id ,Model model) {
        model.addAttribute("kh", khachHangSer.getKhachHangById(id));
        return "/View/BanHang/KhachHang/update";
    }

    @PostMapping("add")
    public String add( KhachHang khachHang ) {
        khachHangSer.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("update")
    public String update( KhachHang khachHang ) {
        khachHangSer.update(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
