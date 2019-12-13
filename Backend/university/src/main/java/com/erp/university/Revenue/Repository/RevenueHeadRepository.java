package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.RevenueHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueHeadRepository extends JpaRepository<RevenueHead ,String> {
}
