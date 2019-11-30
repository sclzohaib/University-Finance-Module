package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Model.Quotation;
import com.erp.university.Purchase.Repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuotationService {

@Autowired
QuotationRepository quotationRepository;

    public ResponseEntity<String> saveQuotation(QuotationDTO quotationDTO) {
        Quotation quotation = new Quotation();
        quotation.setDate(quotationDTO.getDate());
        quotation.setRefNo(quotationDTO.getRefNo());
        quotation.setTermsCondition(quotationDTO.getTermsCondition());
        quotation.setTotal(quotationDTO.getTotal());
        quotationRepository.save(quotation);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);





    }
}
