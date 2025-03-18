package com.asm2.Controller.MauSacController;

import com.asm2.Entity.MauSac.MauSac;
import com.asm2.Serive.MauSac.MauSacSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mau-sac/")
public class MauSacController {
    @Autowired
    private MauSacSer mauSacSer;

    @GetMapping("hien-thi")
    public String hienThi(
            Model model
    ) {
        model.addAttribute("mauSacList", mauSacSer.getMauSac());
        return "/View/BanHang/MauSac/hien-thi";
    }


    @PostMapping("add")
    public String addMauSac(MauSac mauSac) {
        mauSacSer.addMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @PostMapping("update")
    public String editMauSac(MauSac mauSac) {
        mauSacSer.updateMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String detailMauSac(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("ms",mauSacSer.getMauSacByid(id));
        model.addAttribute("mauSacList", mauSacSer.getMauSac());
        return "/View/BanHang/MauSac/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deletevMauSac(@PathVariable("id") Long id) {
        mauSacSer.deleteMauSac(id);
        return "redirect:/mau-sac/hien-thi";

    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id , Model model) {
        model.addAttribute("ms",mauSacSer.getMauSacByid(id));
        return "/View/BanHang/MauSac/MauSacUpdate";

    }
}
