package com.asm2.Repository.LoginRepo;

import com.asm2.Entity.Login.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Long> {
}
