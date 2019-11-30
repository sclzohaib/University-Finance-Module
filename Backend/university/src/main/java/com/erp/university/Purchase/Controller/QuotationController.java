package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Model.Quotation;
import com.erp.university.Purchase.Service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/quotation")
public class QuotationController {
 @Autowired
 QuotationService quotationService;

 //Post Call
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveQuotation(@RequestBody QuotationDTO quotationDTO){

   return quotationService.saveQuotation(quotationDTO);
    }

    //Get call for All Quotation
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Quotation>> getQuotation(){
        return quotationService.getQuotation();
    }

    //Get call for Single Quotation
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Quotation> getQuotationById(@PathVariable("id") Long id){
        return quotationService.getQuotationById(id);
    }

    //Put call for Update Quotation
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuotation(@PathVariable("id") Long id, @RequestBody QuotationDTO quotationDTO){
        return quotationService.updateQuotation(id, quotationDTO);
    }
}
