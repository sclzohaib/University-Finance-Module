package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenderStatusDTO;
import com.erp.university.Purchase.Model.TenderStatus;
import com.erp.university.Purchase.Repository.TenderStatusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenderStatusService {
    private static final Logger logger = LogManager.getLogger(PaymentVoucherService.class);

    @Autowired
    TenderStatusRepository tenderStatusRepository;

    //save
    public ResponseEntity<String> saveTenderStatus(TenderStatusDTO tenderStatusDTO) {
        logger.debug("--------->| Create Tender Status: |<---------");
        logger.debug("TenderStatusDTO: {}", tenderStatusDTO);
        try {
            TenderStatus tenderStatus = new TenderStatus();
            tenderStatus.setName(tenderStatusDTO.getName());
            logger.debug("Tender Status (POST): {}", tenderStatus);
            tenderStatusRepository.save(tenderStatus);
            logger.debug("--------->| Tender Status Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllTenderStatus() {
        logger.debug("--------->| Get All Tender Statuses |<---------");
        List<TenderStatus> tenderStatuses;
        try {
            tenderStatuses = tenderStatusRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (tenderStatuses.isEmpty()) {
            logger.debug("No Tender Status Record Found");
            return new ResponseEntity<>("{\"No Tender Status Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Tender Statuses Found Successfully |<---------");
            return new ResponseEntity<>(tenderStatuses, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getTenderStatusById(Long id) {
        logger.debug("--------->| Get Tender Status By ID |<---------");
        TenderStatus tenderStatus;
        try {
            tenderStatus = tenderStatusRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tender Status Not Found\":1}", HttpStatus.NOT_FOUND);

        }
        logger.debug("--------->| Tender Status Found Successfully |<---------");
        logger.debug("Tender Status (GET): {}", tenderStatus);
        return new ResponseEntity<>(tenderStatus, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateTenderStatus(Long id, TenderStatusDTO tenderStatusDTO) {
        logger.debug("---------> Update Tender Status By ID <---------");
        logger.debug("ID: {}, TenderStatusDTO: {}", id, tenderStatusDTO);
        try {
            TenderStatus tenderStatus = tenderStatusRepository.findById(id).get();
            logger.debug("Old Tender Status: {}", tenderStatus);
            tenderStatus.setName(tenderStatusDTO.getName());
            try {
                logger.debug("Updated Tender Status (Save): {}", tenderStatus);
                tenderStatusRepository.save(tenderStatus);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tender Status Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tender Status Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteTenderStatus(Long id) {
        logger.debug("---------> Delete Tender Status By ID <---------");
        try {
            tenderStatusRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tender Status not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tender Status Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
