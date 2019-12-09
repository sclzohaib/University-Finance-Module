package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDetailDTO;
import com.erp.university.Purchase.Model.QuotationDetail;
import com.erp.university.Purchase.Repository.QuotationDetailRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationDetailService {
    private static final Logger logger = LogManager.getLogger(QuotationDetailService.class);
    @Autowired
    QuotationDetailRepository quotationDetailRepository;

    //Save Quotation Detail
    public ResponseEntity<String> saveQuotationDetail(QuotationDetailDTO quotationDetailDTO) {
        logger.debug("--------->| Create Quotation Detail: |<---------");
        logger.debug("QuotationDetailDTO: {}", quotationDetailDTO);
        try {
            QuotationDetail quotationDetail = new QuotationDetail();
            quotationDetail.setDescription(quotationDetailDTO.getDescription());
            quotationDetail.setBrand(quotationDetailDTO.getBrand());
            quotationDetail.setPriceWithGst(quotationDetailDTO.getPriceWithGst());
            quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
            quotationDetail.setTotal(quotationDetailDTO.getTotal());
            quotationDetail.setUnitPrice(quotationDetailDTO.getUnitPrice());
            logger.debug("Quotation Detail (POST): {}", quotationDetail);
            quotationDetailRepository.save(quotationDetail);
            logger.debug("--------->| Quotation Detail Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);


    }

    //Get all quotation details
    public ResponseEntity<?> getAllQuotationDetail() {
        logger.debug("--------->| Get All Quotation Detail |<---------");
        List<QuotationDetail> quotationDetails;
        try {
            quotationDetails = quotationDetailRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (quotationDetails.isEmpty()) {
            logger.debug("No Quotation Detail Record Found");
            return new ResponseEntity<>("No Quotation Detail Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Quotation Detail Found Successfully |<---------");
            return new ResponseEntity<>(quotationDetails, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getQuotationDetailById(Long id) {
        logger.debug("--------->| Get Quotation Detail By ID |<---------");
        QuotationDetail quotationDetail;
        try {
            quotationDetail = quotationDetailRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Quotation Detail Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Quotation Detail Found Successfully |<---------");
        logger.debug("Quotation Detail (GET): {}", quotationDetail);
        return new ResponseEntity<>(quotationDetail, HttpStatus.FOUND);

    }

    //Update Quotation Detail
    public ResponseEntity<String> updateQuotationDetail(Long id, QuotationDetailDTO quotationDetailDTO) {
        logger.debug("---------> Update Quotation Detail By ID <---------");
        logger.debug("ID: {}, QuotationDetailDTO: {}", id, quotationDetailDTO);
        try {
            QuotationDetail quotationDetail = quotationDetailRepository.findById(id).get();
            logger.debug("Old Quotation Detail: {}", quotationDetail);
            quotationDetail.setBrand(quotationDetailDTO.getBrand());
            quotationDetail.setDescription(quotationDetailDTO.getDescription());
            quotationDetail.setPriceWithGst(quotationDetailDTO.getPriceWithGst());
            quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
            quotationDetail.setTotal(quotationDetail.getTotal());
            quotationDetail.setUnitPrice(quotationDetail.getUnitPrice());
            try {
                logger.debug("Updated Quotation Detail (Save): {}", quotationDetail);
                quotationDetailRepository.save(quotationDetail);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Quotation Detail Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Quotation Detail Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
