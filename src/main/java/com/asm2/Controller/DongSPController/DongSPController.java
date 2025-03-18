package com.asm2.Controller.DongSPController;

import com.asm2.Entity.DongSP.DongSP;
import com.asm2.Serive.DongSpSer.DongSPSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dong-sp/")
public class DongSPController {
    @Autowired
    private DongSPSer dongSPSer;



    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("dongSpLists", dongSPSer.getList());
        return "/View/BanHang/DongSP/hienThi";
    }


    @PostMapping("add")
    public String addMauSac(DongSP dongSP) {
        dongSPSer.save(dongSP);
        return "redirect:/dong-sp/hien-thi";
    }
    @PostMapping("update")
    public String editMauSac(DongSP dongSP) {
        dongSPSer.update(dongSP);
        return "redirect:/dong-sp/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String detailMauSac(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("ds",dongSPSer.findById(id));
        model.addAttribute("dongSpLists", dongSPSer.getList());
        return "/View/BanHang/DongSP/hienThi";
    }

    @GetMapping("delete/{id}")
    public String deletevMauSac(@PathVariable("id") Long id) {
        dongSPSer.delete(id);
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("showViewUpdate/{id}")
    public String showViewUpdate(@PathVariable("id") Long id , Model model) {
        model.addAttribute("ds",dongSPSer.findById(id));
        return "/View/BanHang/DongSP/update";

    }
}
