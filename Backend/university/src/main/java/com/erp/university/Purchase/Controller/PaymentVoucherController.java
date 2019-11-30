package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Service.PaymentVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PaymentVoucherController {
@Autowired
    PaymentVoucherService paymentVoucherService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> savePaymentVoucher(@RequestBody PaymentVoucherDTO paymentVoucherDTO)
{
    return paymentVoucherService.savePaymentVoucher(paymentVoucherDTO);
}
}
