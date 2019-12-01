package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.MajorHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorHeadRepository extends JpaRepository<MajorHead,Long> {
}
