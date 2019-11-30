package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/quotation")
public class QuotationController {
 @Autowired
 QuotationService quotationService;
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveQuotation(@RequestBody QuotationDTO quotationDTO){

   return quotationService.saveQuotation(quotationDTO);
    }
}
