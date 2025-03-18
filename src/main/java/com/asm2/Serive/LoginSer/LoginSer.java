package com.asm2.Serive.LoginSer;

import com.asm2.Entity.Login.Login;
import com.asm2.Repository.LoginRepo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginSer {
    @Autowired
    private LoginRepo loginRepo;

    public List<Login> getLogins() {
        return loginRepo.findAll();
    }
}
