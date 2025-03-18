package com.asm2.Controller.ChucVuController;

import com.asm2.Entity.ChucVu.ChucVu;
import com.asm2.Entity.CuaHang.CuaHang;
import com.asm2.Serive.ChucVuSer.ChucVuSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chuc-vu/")
public class ChucVuController {
        @Autowired
        private ChucVuSer chucVuSer;

        @GetMapping("hien-thi")
    public String chucVuHienThi(
            Model model
        ) {
            model.addAttribute("chucVuLists", chucVuSer.getChucVus());
            return "/View/BanHang/ChucVu/chuc-vu-hien-thi";
        }


    @PostMapping("add")
    public String addChucVu(ChucVu chucVu) {
        chucVuSer.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @PostMapping("update")
    public String editChucVu(ChucVu chucVu) {
        chucVuSer.update(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String detailChucVu(
            @PathVariable("id")Long id,
            Model model) {
        model.addAttribute("cv",chucVuSer.getChucVuById(id));
        model.addAttribute("chucVuLists", chucVuSer.getChucVus());
        return "/View/BanHang/ChucVu/chuc-vu-hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deleteChucVu(@PathVariable("id") Long id) {
        chucVuSer.delete(id);
        return "redirect:/chuc-vu/hien-thi";

    }

    @GetMapping("showViewUpdate/{id}")
    public String detailCuaHang(@PathVariable("id") Long id , Model model) {
        model.addAttribute("cv",chucVuSer.getChucVuById(id));
        return "/View/BanHang/ChucVu/chucVuUpdate";

    }
}
