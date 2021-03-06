package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Service.PaymentVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/paymentVoucher")
public class PaymentVoucherController {
    @Autowired
    PaymentVoucherService paymentVoucherService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> savePaymentVoucher(@Valid @RequestBody PaymentVoucherDTO paymentVoucherDTO) {
        return paymentVoucherService.savePaymentVoucher(paymentVoucherDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPaymentVoucher() {
        return paymentVoucherService.getAllPaymentVoucher();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPaymentVoucherById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return paymentVoucherService.getPaymentVoucherById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePaymentVoucher(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody PaymentVoucherDTO paymentVoucherDTO) {
        return paymentVoucherService.updatePaymentVoucher(id, paymentVoucherDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePaymentVoucher(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return paymentVoucherService.deletePaymentVoucher(id);
    }
}
