package com.asm2.Controller.TrangChuController;


import com.asm2.Serive.CuaHangSer.CuaHangSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/ASM2/")
public class TrangChuController {
        @GetMapping("trang-chu")
        public String trangChu() {
            return "/View/Home/trang-chu";
        }

    }

