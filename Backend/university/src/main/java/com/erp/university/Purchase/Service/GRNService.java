package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GRNDTO;
import com.erp.university.Purchase.Model.GRN;
import com.erp.university.Purchase.Repository.GRNRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GRNService {
    private static final Logger logger = LogManager.getLogger(GRNService.class);
    @Autowired
    GRNRepository grnRepository;

    //Save GRN
    public ResponseEntity<String> saveGRN(GRNDTO grndto) {
        logger.debug("--------->| Create GRN: |<---------");
        logger.debug("GRNDTO: {}", grndto);
        try {
            GRN grn = new GRN();
            grn.setDate(grndto.getDate());
            grn.setGrnNo(grndto.getGrnNo());
            grn.setPurchaseDate(grndto.getPurchaseDate());
            grn.setInspectedBy(grndto.getInspectedBy());
            grn.setPostedBy(grndto.getPostedBy());
            grn.setReasonForRejection(grndto.getReasonForRejection());
            grn.setRecievedQuantity(grndto.getRecievedQuantity());
            grn.setDepartmentHead(grndto.getDepartmentHead());
            grn.setTotalQuantity(grndto.getTotalQuantity());
            grn.setStatus(grndto.getStatus());
            logger.debug("GRN (POST): {}", grn);
            grnRepository.save(grn);
            logger.debug("--------->| GRN Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //GET ALL GRN

    public ResponseEntity<?> getGRN() {
        logger.debug("--------->| Get All GRN |<---------");
        List<GRN> grns;
        try {
            grns = grnRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (grns.isEmpty()) {
            logger.debug("No GRN Record Found");
            return new ResponseEntity<>("No GRN Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| GRN Found Successfully |<---------");
            return new ResponseEntity<>(grns, HttpStatus.FOUND);
        }
    }

    //GET Single GRN by ID

    public ResponseEntity<?> getGRNById(Long id) {
        logger.debug("--------->| Get GRN By ID |<---------");
        GRN grn;
        try {
            grn = grnRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("GRN Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| GRN Found Successfully |<---------");
        logger.debug("GRN (GET): {}", grn);
        return new ResponseEntity<>(grn, HttpStatus.FOUND);
    }

    //Update GRN By Id
    public ResponseEntity<String> updateGRN(Long id, GRNDTO grndto) {
        logger.debug("---------> Update GRN By ID<---------");
        logger.debug("ID: {}, GRNDTO: {}", id, grndto);
        try {
            GRN grn = grnRepository.findById(id).get();
            logger.debug("Old GRN: {}", grn);
            grn.setDate(grndto.getDate());
            grn.setDepartmentHead(grndto.getDepartmentHead());
            grn.setGrnNo(grndto.getGrnNo());
            grn.setInspectedBy(grndto.getInspectedBy());
            grn.setPostedBy(grndto.getPostedBy());
            grn.setPurchaseDate(grndto.getPurchaseDate());
            grn.setReasonForRejection(grndto.getReasonForRejection());
            grn.setRecievedBy(grndto.getRecievedBy());
            grn.setRecievedQuantity(grndto.getRecievedQuantity());
            grn.setStatus(grndto.getStatus());
            grn.setTotalQuantity(grndto.getTotalQuantity());
            try {
                logger.debug("Updated GRN (Save): {}", grn);
                grnRepository.save(grn);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("GRN Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| GRN Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
