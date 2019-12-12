package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue,String> {
}
