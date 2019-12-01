package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PaymentVoucherDTO;
import com.erp.university.Purchase.Model.PaymentVoucher;
import com.erp.university.Purchase.Service.PaymentVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  (value= "/api/paymentVoucher")
public class PaymentVoucherController {
@Autowired
    PaymentVoucherService paymentVoucherService;

//Post
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> savePaymentVoucher(@RequestBody PaymentVoucherDTO paymentVoucherDTO)
{
    return paymentVoucherService.savePaymentVoucher(paymentVoucherDTO);
}

//Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentVoucher>> getAll(){
    return paymentVoucherService.getAll();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PaymentVoucher> getById(@PathVariable("id") Long id){
    return paymentVoucherService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody PaymentVoucherDTO paymentVoucherDTO){
    return paymentVoucherService.update(id, paymentVoucherDTO);
    }
}
