package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.MinorHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinorHeadRepository extends JpaRepository<MinorHead, Long> {
}
