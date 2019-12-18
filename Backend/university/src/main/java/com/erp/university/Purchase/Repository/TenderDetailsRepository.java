package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.TenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderDetailsRepository extends JpaRepository<TenderDetails, Long> {
}
