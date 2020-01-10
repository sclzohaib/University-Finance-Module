package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Model.PaymentVoucher;
import com.erp.university.Purchase.Repository.PaymentVoucherRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentVoucherService {
    private static final Logger logger = LogManager.getLogger(PaymentVoucherService.class);
    @Autowired
    PaymentVoucherRepository paymentVoucherRepository;

    //Save
    public ResponseEntity<String> savePaymentVoucher(PaymentVoucherDTO paymentVoucherDTO) {
        logger.debug("--------->| Create Payment Voucher: |<---------");
        logger.debug("PaymentVoucherDTO: {}", paymentVoucherDTO);
        try {
            PaymentVoucher paymentVoucher = new PaymentVoucher();
            paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
            paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
            paymentVoucher.setDate(paymentVoucherDTO.getDate());
            paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
            paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
            paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
            logger.debug("Payment Voucher (POST): {}", paymentVoucher);
            paymentVoucherRepository.save(paymentVoucher);
            logger.debug("--------->| Payment Voucher Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllPaymentVoucher() {
        logger.debug("--------->| Get All Payment Vouchers |<---------");
        List<PaymentVoucher> paymentVouchers;
        try {
            paymentVouchers = paymentVoucherRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (paymentVouchers.isEmpty()) {
            logger.debug("No Payment Voucher Record Found");
            return new ResponseEntity<>("{\"No Payment Voucher Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Payment Voucher Found Successfully |<---------");
            return new ResponseEntity<>(paymentVouchers, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getPaymentVoucherById(Long id) {
        logger.debug("--------->| Get Payment Voucher By ID |<---------");
        PaymentVoucher paymentVoucher;
        try {
            paymentVoucher = paymentVoucherRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Payment Voucher Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Payment Voucher Found Successfully |<---------");
        logger.debug("Payment Voucher (GET): {}", paymentVoucher);
        return new ResponseEntity<>(paymentVoucher, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updatePaymentVoucher(Long id, PaymentVoucherDTO paymentVoucherDTO) {
        logger.debug("---------> Update Payment Voucher By ID <---------");
        logger.debug("ID: {}, PaymentVoucherDTO: {}", id, paymentVoucherDTO);
        try {
            PaymentVoucher paymentVoucher = paymentVoucherRepository.findById(id).get();
            logger.debug("Old Payment Voucher: {}", paymentVoucher);
            paymentVoucher.setAccountCode(paymentVoucherDTO.getAccountCode());
            paymentVoucher.setAccountDescription(paymentVoucherDTO.getAccountDescription());
            paymentVoucher.setDate(paymentVoucherDTO.getDate());
            paymentVoucher.setPayeeCode(paymentVoucherDTO.getPayeeCode());
            paymentVoucher.setPayeeName(paymentVoucherDTO.getPayeeName());
            paymentVoucher.setPaymentVoucherNo(paymentVoucherDTO.getPaymentVoucherNo());
            try {
                logger.debug("Updated Payment Voucher (Save): {}", paymentVoucher);
                paymentVoucherRepository.save(paymentVoucher);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Payment Voucher Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Payment Voucher Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deletePaymentVoucher(Long id) {
        logger.debug("---------> Delete Payment Voucher By ID <---------");
        try {
            paymentVoucherRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Payment Voucher not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Payment Voucher Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
