package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Model.PaymentVoucher;
import com.erp.university.Purchase.Repository.PaymentVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentVoucherService {
@Autowired
    PaymentVoucherRepository paymentVoucherRepository;
public ResponseEntity<String > savePaymentVoucher(PaymentVoucherDTO paymentVoucherDTO)
{
    PaymentVoucher paymentVoucher=new PaymentVoucher();
    paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
    paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
    paymentVoucher.setDate(paymentVoucherDTO.getDate());
    paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
    paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
    paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
    paymentVoucherRepository.save(paymentVoucher);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

}

}
