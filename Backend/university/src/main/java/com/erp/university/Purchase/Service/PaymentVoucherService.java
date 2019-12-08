package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Model.PaymentVoucher;
import com.erp.university.Purchase.Repository.PaymentVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentVoucherService {
    @Autowired
    PaymentVoucherRepository paymentVoucherRepository;

    //Save
    public ResponseEntity<String> savePaymentVoucher(PaymentVoucherDTO paymentVoucherDTO) {
        PaymentVoucher paymentVoucher = new PaymentVoucher();
        paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
        paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
        paymentVoucher.setDate(paymentVoucherDTO.getDate());
        paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
        paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
        paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
        paymentVoucherRepository.save(paymentVoucher);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<List<PaymentVoucher>> getAllPaymentVoucher() {
        List<PaymentVoucher> paymentVouchers = paymentVoucherRepository.findAll();
        return new ResponseEntity<List<PaymentVoucher>>(paymentVouchers, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<PaymentVoucher> getPaymentVoucherById(Long id) {
        PaymentVoucher paymentVoucher = paymentVoucherRepository.findById(id).get();
        return new ResponseEntity<PaymentVoucher>(paymentVoucher, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updatePaymentVoucher(Long id, PaymentVoucherDTO paymentVoucherDTO) {
        PaymentVoucher paymentVoucher = paymentVoucherRepository.findById(id).get();
        paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
        paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
        paymentVoucher.setDate(paymentVoucherDTO.getDate());
        paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
        paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
        paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
        paymentVoucherRepository.save(paymentVoucher);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
