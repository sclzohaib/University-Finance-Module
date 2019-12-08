package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Model.Quotation;
import com.erp.university.Purchase.Repository.QuotationRepository;
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
        try {
            Quotation quotation = new Quotation();
            quotation.setDate(quotationDTO.getDate());
            quotation.setRefNo(quotationDTO.getRefNo());
            quotation.setTermsCondition(quotationDTO.getTermsCondition());
            quotation.setTotal(quotationDTO.getTotal());
            quotationRepository.save(quotation);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all Quotations
    public ResponseEntity<?> getAllQuotation() {
        List<Quotation> quotations;
        try {
            quotations = quotationRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quotations, HttpStatus.FOUND);
    }

    //Get Quotations By id
    public ResponseEntity<?> getQuotationById(Long id) {
        Quotation quotation;
        try {
            quotation = quotationRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Quotation Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quotation, HttpStatus.FOUND);
    }

    //Update Quotation by Id
    public ResponseEntity<String> updateQuotation(Long id, QuotationDTO quotationDTO) {
        try {
            Quotation quotation = quotationRepository.findById(id).get();
            quotation.setDate(quotationDTO.getDate());
            quotation.setRefNo(quotationDTO.getRefNo());
            quotation.setTermsCondition(quotationDTO.getTermsCondition());
            quotation.setTotal(quotationDTO.getTotal());
            try {
                quotationRepository.save(quotation);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Quotation Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
