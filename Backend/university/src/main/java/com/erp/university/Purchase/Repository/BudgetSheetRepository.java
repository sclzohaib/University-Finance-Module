package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.BudgetSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetSheetRepository extends JpaRepository<BudgetSheet, Long> {
}
