package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue,String> {
}
