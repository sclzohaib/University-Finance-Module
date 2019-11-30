package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Service.QuotationDetailService;
import com.erp.university.Purchase.Service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value ="/api/quotationDeatil")

public class QuotationDetailController {
    @Autowired
    QuotationDetailService quotationDetailService;
    @RequestMapping (value ="/",method =RequestMethod.POST)
    public ResponseEntity<String> saveQuotationDetail(@RequestBody QuotationDetailDTO quotationDetailDTO){
       return quotationDetailService.saveQuotationDetail(quotationDetailDTO);
    }



}
