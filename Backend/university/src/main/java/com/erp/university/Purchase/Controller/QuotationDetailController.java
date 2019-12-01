package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Model.QuotationDetail;
import com.erp.university.Purchase.Service.QuotationDetailService;
import com.erp.university.Purchase.Service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value ="/api/quotationDetail")

public class QuotationDetailController {
    @Autowired
    QuotationDetailService quotationDetailService;

    //Post Call
    @RequestMapping (value ="/",method =RequestMethod.POST)
    public ResponseEntity<String> saveQuotationDetail(@RequestBody QuotationDetailDTO quotationDetailDTO){
       return quotationDetailService.saveQuotationDetail(quotationDetailDTO);
    }

    //Get Call for all Quotation Detail
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<QuotationDetail>> getQuotationDetail(){
        return quotationDetailService.getQuotationDetail();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuotationDetail> getQuotationDetailById(@PathVariable("id") Long id){
        return quotationDetailService.getQuotationDetailById(id);
    }

    //Update Quotation Detail
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuotationDetail(@PathVariable("id") Long id, @RequestBody QuotationDetailDTO quotationDetailDTO){
        return quotationDetailService.updateQuotationDetail(id, quotationDetailDTO);
    }

}
