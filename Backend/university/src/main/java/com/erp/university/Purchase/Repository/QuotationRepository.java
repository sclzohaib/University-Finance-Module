package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {


}
