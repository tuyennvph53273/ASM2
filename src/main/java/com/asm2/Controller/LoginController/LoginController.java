package com.asm2.Controller.LoginController;

import com.asm2.Entity.ChucVu.ChucVu;
import com.asm2.Entity.Login.Login;
import com.asm2.Entity.NhanVien.NhanVien;
import com.asm2.Serive.ChucVuSer.ChucVuSer;
import com.asm2.Serive.LoginSer.LoginSer;
import com.asm2.Serive.NhanVienSer.NhanVIenSer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ASM2/")
public class LoginController {
    @Autowired
    private LoginSer loginSer;
    @Autowired
    private ChucVuSer chucVuSer;

    @Autowired
    private NhanVIenSer nhanVienSer;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listsChucVu", chucVuSer.getChucVus());
        model.addAttribute("listsLogin", loginSer.getLogins());
        return "/View/Login/hien-thi";
    }
    @PostMapping("home")
    public String home(HttpSession session,
                       @RequestParam("ten") String ten,
                       @RequestParam("matkhau") String matkhau,
                       @RequestParam("chucVu") String chucVu,
                       Model model) {
        model.addAttribute("listsChucVu", chucVuSer.getChucVus());
        model.addAttribute("listsLogin", loginSer.getLogins());

        NhanVien nhanVien = nhanVienSer.findByTen(ten);

        if (nhanVien == null || !nhanVien.getMatKhau().equals(matkhau) || !nhanVien.getChucVu().getTen().equals(chucVu)) {
            model.addAttribute("error", "Sai thông tin đăng nhập!");
            return "/View/Login/hien-thi";
        }

        session.setAttribute("chucVu", nhanVien.getChucVu().getTen());

        return "redirect:/ASM2/trang-chu";
    }


    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/ASM2/hien-thi";
    }

}


