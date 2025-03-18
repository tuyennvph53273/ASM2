package com.asm2.Repository.NsxREPO;

import com.asm2.Entity.NSX.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NsxRepo extends JpaRepository<NSX, Long> {
}
