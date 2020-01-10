package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/quotation")
public class QuotationController {
    @Autowired
    QuotationService quotationService;

    //Post Call
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveQuotation(@Valid @RequestBody QuotationDTO quotationDTO) {

        return quotationService.saveQuotation(quotationDTO);
    }

    //Get call for All Quotation
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuotation() {
        return quotationService.getAllQuotation();
    }

    //Get call for Single Quotation
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuotationById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return quotationService.getQuotationById(id);
    }

    //Put call for Update Quotation
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuotation(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody QuotationDTO quotationDTO) {
        return quotationService.updateQuotation(id, quotationDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteQuotation(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return quotationService.deleteQuotation(id);
    }
}
