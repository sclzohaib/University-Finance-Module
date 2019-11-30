package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Model.QuotationDetail;
import com.erp.university.Purchase.Repository.QuotationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationDetailService {
    @Autowired
    QuotationDetailRepository quotationDetailRepository;

    //Save Quotation Detail
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

    //Get all quotation details
    public ResponseEntity<List<QuotationDetail>> getQuotationDetail(){
        List<QuotationDetail> quotationDetails = quotationDetailRepository.findAll();
        return new ResponseEntity<List<QuotationDetail>>(quotationDetails, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<QuotationDetail> getQuotationDetailById(Long id){
        QuotationDetail quotationDetail = quotationDetailRepository.findById(id).get();
        return new ResponseEntity<QuotationDetail>(quotationDetail,HttpStatus.FOUND);

    }

    //Update Quotation Detail
    public ResponseEntity<String> updateQuotationDetail(Long id, QuotationDetailDTO quotationDetailDTO){
        QuotationDetail quotationDetail = quotationDetailRepository.findById(id).get();
        quotationDetail.setBrand(quotationDetailDTO.getBrand());
        quotationDetail.setDescription(quotationDetailDTO.getDescription());
        quotationDetail.setPriceWithGst(quotationDetailDTO.getPriceWithGst());
        quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
        quotationDetail.setTotal(quotationDetail.getTotal());
        quotationDetail.setUnitPrice(quotationDetail.getUnitPrice());
        quotationDetailRepository.save(quotationDetail);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
