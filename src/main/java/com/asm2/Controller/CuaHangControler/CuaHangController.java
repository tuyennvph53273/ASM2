package com.asm2.Controller.CuaHangControler;

import com.asm2.Entity.CuaHang.CuaHang;
import com.asm2.Serive.CuaHangSer.CuaHangSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangSer cuaHangSer;

    @GetMapping("/cua-hang-hien-thi")
    public String CuaHangThi(
            Model model
    ) {
        model.addAttribute("CuaHangLists",cuaHangSer.getCuaHang());
        return "/View/BanHang/CuaHang/cua-hang-hien-thi";

    }
    @PostMapping("add")
    public String addCuaHang(CuaHang cuaHang) {
        cuaHangSer.save(cuaHang);
        return "redirect:/cua-hang/cua-hang-hien-thi";
    }
    @PostMapping("edit")
    public String editCuaHang(CuaHang cuaHang) {
        cuaHangSer.update(cuaHang);
        return "redirect:/cua-hang/cua-hang-hien-thi";
    }
    @GetMapping("update/{id}")
    public String updateCuaHang(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("ch",cuaHangSer.getCuaHangById(id));
        return "/View/BanHang/CuaHang/UpdateCuaHang";
    }

    @GetMapping("delete/{id}")
    public String deleteCuaHang(@PathVariable("id") Long id) {
        cuaHangSer.delete(id);
        return "redirect:/cua-hang/cua-hang-hien-thi";
    }

    @GetMapping("showViewUpdate/{id}")
    public String detailCuaHang(@PathVariable("id") Long id , Model model) {
        model.addAttribute("ch",cuaHangSer.getCuaHangById(id));
        model.addAttribute("CuaHangLists",cuaHangSer.getCuaHang());
        return "/View/BanHang/CuaHang/cua-hang-hien-thi";

    }

}
