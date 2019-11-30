package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Model.QuotationDetail;
import com.erp.university.Purchase.Repository.QuotationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuotationDetailService {
    @Autowired
    QuotationDetailRepository quotationDetailRepository;

    public ResponseEntity<String> saveQuotationDetail(QuotationDetailDTO quotationDetailDTO){
        QuotationDetail quotationDetail =new QuotationDetail();
        quotationDetail.setDescription(quotationDetailDTO.getDescription());
        quotationDetail.setBrand(quotationDetailDTO.getBrand());
        quotationDetail.setPriceWithGst(quotationDetailDTO.getPriceWithGst());
        quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
        quotationDetail.setTotal(quotationDetailDTO.getTotal());
        quotationDetail.setUnitPrice(quotationDetailDTO.getUnitPrice());
        quotationDetailRepository.save(quotationDetail);
        return new ResponseEntity<String>("Added successfully", HttpStatus.CREATED);


    }
}
