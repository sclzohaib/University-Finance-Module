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
        try {
            PaymentVoucher paymentVoucher = new PaymentVoucher();
            paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
            paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
            paymentVoucher.setDate(paymentVoucherDTO.getDate());
            paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
            paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
            paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
            paymentVoucherRepository.save(paymentVoucher);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllPaymentVoucher() {
        List<PaymentVoucher> paymentVouchers;
        try {
            paymentVouchers = paymentVoucherRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentVouchers, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getPaymentVoucherById(Long id) {
        PaymentVoucher paymentVoucher;
        try {
            paymentVoucher = paymentVoucherRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Payment Voucher Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentVoucher, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updatePaymentVoucher(Long id, PaymentVoucherDTO paymentVoucherDTO) {
        try {
            PaymentVoucher paymentVoucher = paymentVoucherRepository.findById(id).get();
            paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
            paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
            paymentVoucher.setDate(paymentVoucherDTO.getDate());
            paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
            paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
            paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
            try {
                paymentVoucherRepository.save(paymentVoucher);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Payment Voucher Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
