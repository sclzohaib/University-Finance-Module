package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.PaymentVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentVoucherRepository extends JpaRepository<PaymentVoucher, Long> {
}
