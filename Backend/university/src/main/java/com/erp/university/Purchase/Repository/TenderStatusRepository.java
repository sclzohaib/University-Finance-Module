package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.TenderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderStatusRepository extends JpaRepository<TenderStatus, Long> {
}
