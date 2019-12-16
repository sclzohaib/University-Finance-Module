package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.FeeTypeDTO;
import com.erp.university.Revenue.Model.FeeType;
import com.erp.university.Revenue.Repository.FeeTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeTypeService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    FeeTypeRepository feeTypeRepository;

    //save
    public ResponseEntity<String> saveFeeType(FeeTypeDTO feeTypeDTO) {
        logger.debug("--------->| Create Fee Type: |<---------");
        logger.debug("FeeTypeDTO: {}", feeTypeDTO);
        try {
            FeeType feeType = new FeeType();
            feeType.setAmount(feeTypeDTO.getAmount());
            feeType.setClasses(feeTypeDTO.getClasses());
            feeType.setDescription(feeTypeDTO.getDescription());
            feeType.setParts(feeTypeDTO.getParts());
            feeType.setRevenueHead(feeTypeDTO.getRevenueHead());
            feeType.setStudentTypes(feeTypeDTO.getStudentTypes());
            logger.debug("Fee Type (POST): {}", feeType);
            feeTypeRepository.save(feeType);
            logger.debug("--------->| Fee Type Created |<---------");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllFeeType() {
        logger.debug("--------->| Get All Fee types |<---------");
        List<FeeType> feeTypes;
        try {
            feeTypes = feeTypeRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (feeTypes.isEmpty()) {
            logger.debug("No Fee type Record Found");
            return new ResponseEntity<>("No Fee type Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Fee types Found Successfully |<---------");
            return new ResponseEntity<>(feeTypes, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getFeeTypeById(Long id) {
        logger.debug("--------->| Get Fee type By ID |<---------");
        FeeType feeType;
        try {
            feeType = feeTypeRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Fee type not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Fee type Found Successfully |<---------");
        logger.debug("Fee type (GET): {}", feeType);
        return new ResponseEntity<>(feeType, HttpStatus.FOUND);
    }

    //Update by id
    public ResponseEntity<String> updateFeeType(Long id, FeeTypeDTO feeTypeDTO) {
        logger.debug("---------> Update Fee Type By ID <---------");
        logger.debug("ID: {}, FeeTypeDTO: {}", id, feeTypeDTO);
        try {
            FeeType feeType = feeTypeRepository.findById(id).get();
            logger.debug("Old Fee Type: {}", feeType);
            feeType.setAmount(feeTypeDTO.getAmount());
            feeType.setClasses(feeTypeDTO.getClasses());
            feeType.setDescription(feeTypeDTO.getDescription());
            feeType.setParts(feeTypeDTO.getParts());
            feeType.setRevenueHead(feeTypeDTO.getRevenueHead());
            feeType.setStudentTypes(feeTypeDTO.getStudentTypes());
            feeType.setWithForm(feeTypeDTO.getWithForm());
            try {
                logger.debug("Updated Fee Type (Save): {}", feeType);
                feeTypeRepository.save(feeType);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Fee type not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Fee Type Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    //Delete by id
    public ResponseEntity<String> deleteFeeType(Long id) {
        logger.debug("---------> Delete Fee Type By ID <---------");
        try {
            feeTypeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Fee type not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Fee Type Deleted Successfully |<---------");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
