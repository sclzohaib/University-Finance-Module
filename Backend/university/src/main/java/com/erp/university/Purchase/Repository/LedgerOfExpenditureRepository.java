package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.LedgerOfExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerOfExpenditureRepository extends JpaRepository<LedgerOfExpenditure, Long> {
}
