package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Model.Quotation;
import com.erp.university.Purchase.Repository.QuotationRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

@Autowired
QuotationRepository quotationRepository;


//Save Quotation
    public ResponseEntity<String> saveQuotation(QuotationDTO quotationDTO) {
        Quotation quotation = new Quotation();
        quotation.setDate(quotationDTO.getDate());
        quotation.setRefNo(quotationDTO.getRefNo());
        quotation.setTermsCondition(quotationDTO.getTermsCondition());
        quotation.setTotal(quotationDTO.getTotal());
        quotationRepository.save(quotation);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
}

    //Get all Quotations
    public ResponseEntity<List<Quotation>> getQuotation(){
        List<Quotation> quotations = quotationRepository.findAll();
        return new ResponseEntity<List<Quotation>>(quotations, HttpStatus.FOUND);
    }

    //Get Quotations By id
    public ResponseEntity<Quotation> getQuotationById(Long id){
        Quotation quotation = quotationRepository.findById(id).get();
        return new ResponseEntity<Quotation>(quotation, HttpStatus.FOUND);
    }

    //Update Quotation by Id
    public ResponseEntity<String> updateQuotation(Long id, QuotationDTO quotationDTO){
        Quotation quotation = quotationRepository.findById(id).get();
        quotation.setDate(quotationDTO.getDate());
        quotation.setRefNo(quotationDTO.getRefNo());
        quotation.setTermsCondition(quotationDTO.getTermsCondition());
        quotation.setTotal(quotationDTO.getTotal());
        quotationRepository.save(quotation);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
