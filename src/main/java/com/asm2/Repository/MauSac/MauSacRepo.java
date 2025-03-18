package com.asm2.Repository.MauSac;

import com.asm2.Entity.MauSac.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Long> {
}
