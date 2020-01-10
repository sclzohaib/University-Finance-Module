package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Service.QuotationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/quotationDetail")

public class QuotationDetailController {
    @Autowired
    QuotationDetailService quotationDetailService;

    //Post Call
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveQuotationDetail(@Valid @RequestBody QuotationDetailDTO quotationDetailDTO) {
        return quotationDetailService.saveQuotationDetail(quotationDetailDTO);
    }

    //Get Call for all Quotation Detail
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuotationDetail() {
        return quotationDetailService.getAllQuotationDetail();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuotationDetailById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return quotationDetailService.getQuotationDetailById(id);
    }

    //Update Quotation Detail
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuotationDetail(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody QuotationDetailDTO quotationDetailDTO) {
        return quotationDetailService.updateQuotationDetail(id, quotationDetailDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteQuotationDetail(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return quotationDetailService.deleteQuotationDetail(id);
    }

}
