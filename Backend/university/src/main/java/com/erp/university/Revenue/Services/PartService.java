package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.PartDTO;
import com.erp.university.Revenue.Model.Part;
import com.erp.university.Revenue.Repository.PartRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    PartRepository partRepository;

    //save
    public ResponseEntity<String> savePart(PartDTO partDTO) {
        logger.debug("--------->| Create Part: |<---------");
        logger.debug("PartDTO: {}", partDTO);
        try {
            Part part = new Part();
            part.setName(partDTO.getName());
            logger.debug("Part (POST): {}", part);
            partRepository.save(part);
            logger.debug("--------->| Part Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllPart() {
        logger.debug("--------->| Get All Parts |<---------");
        List<Part> parts;
        try {
            parts = partRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (parts.isEmpty()) {
            logger.debug("No Part Record Found");
            return new ResponseEntity<>("No Part Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Parts Found Successfully |<---------");
            return new ResponseEntity<>(parts, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getPartById(Long id) {
        logger.debug("--------->| Get Part By ID |<---------");
        Part part;
        try {
            part = partRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Part not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Part Found Successfully |<---------");
        logger.debug("Part (GET): {}", part);
        return new ResponseEntity<>(part, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updatePart(Long id, PartDTO partDTO) {
        logger.debug("---------> Update Part By ID <---------");
        logger.debug("ID: {}, PartDTO: {}", id, partDTO);
        try {
            Part part = partRepository.findById(id).get();
            logger.debug("Old Part: {}", part);
            part.setName(partDTO.getName());
            try {
                logger.debug("Updated Part (Save): {}", part);
                partRepository.save(part);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Part not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Part Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deletePart(Long id) {
        logger.debug("---------> Delete Part By ID <---------");
        try {
            partRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Part not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Part Deleted Successfully |<---------");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
