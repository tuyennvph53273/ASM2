package com.asm2.Controller.NsxControlelr;

import com.asm2.Entity.MauSac.MauSac;
import com.asm2.Entity.NSX.NSX;
import com.asm2.Serive.NsxSer.NsxSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nsx/")
public class NsxController {
    @Autowired
    private NsxSer nsxSer;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("nsxLists", nsxSer.findAll());
        return "/View/BanHang/Nsx/hien-thi";
    }


    @PostMapping("add")
    public String addMauSac(NSX nsx) {
        nsxSer.save(nsx);
        return "redirect:/nsx/hien-thi";
    }
    @PostMapping("update")
    public String editMauSac(NSX nsx) {
        nsxSer.update(nsx);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String detailMauSac(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("ns",nsxSer.findById(id));
        model.addAttribute("nsxLists", nsxSer.findAll());
        return "/View/BanHang/Nsx/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deletevMauSac(@PathVariable("id") Long id) {
        nsxSer.delete(id);
        return "redirect:/nsx/hien-thi";

    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id , Model model) {
        model.addAttribute("ns",nsxSer.findById(id));
        return "/View/BanHang/Nsx/update";

    }
}
