package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.QuotationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationDetailRepository extends JpaRepository<QuotationDetail, Long> {

}
