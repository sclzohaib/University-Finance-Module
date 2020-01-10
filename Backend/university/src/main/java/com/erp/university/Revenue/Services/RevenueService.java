package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.RevenueDTO;
import com.erp.university.Revenue.Model.Revenue;
import com.erp.university.Revenue.Repository.RevenueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    RevenueRepository revenueRepository;

    //save
    public ResponseEntity<String> saveRevenue(RevenueDTO revenueDTO) {
        logger.debug("--------->| Create Revenue: |<---------");
        logger.debug("RevenueDTO: {}", revenueDTO);
        try {
            Revenue revenue = new Revenue();
            revenue.setAmount(revenueDTO.getAmount());
            revenue.setDescription(revenueDTO.getDescription());
            revenue.setPaid(revenueDTO.getPaid());
            revenue.setPart(revenueDTO.getPart());
            revenue.setRevenueHead(revenueDTO.getRevenueHead());
            revenue.setStdClass(revenueDTO.getStdClass());
            revenue.setStudentType(revenueDTO.getStudentType());
            revenue.setWithForm(revenueDTO.getWithForm());
            logger.debug("Revenue (POST): {}", revenue);
            revenueRepository.save(revenue);
            logger.debug("--------->| Revenue Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added successfully\":1}", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllRevenue() {
        logger.debug("--------->| Get All Revenues |<---------");
        List<Revenue> revenues;
        try {
            revenues = revenueRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (revenues.isEmpty()) {
            logger.debug("No Revenue Record Found");
            return new ResponseEntity<>("{\"No Revenue Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Revenues Found Successfully |<---------");
            return new ResponseEntity<>(revenues, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getRevenueById(Long id) {
        logger.debug("--------->| Get Revenue By ID |<---------");
        Revenue revenue;
        try {
            revenue = revenueRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Revenue not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Found Successfully |<---------");
        logger.debug("Revenue (GET): {}", revenue);
        return new ResponseEntity<>(revenue, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateRevenue(Long id, RevenueDTO revenueDTO) {
        logger.debug("---------> Update Revenue By ID <---------");
        logger.debug("ID: {}, RevenueDTO: {}", id, revenueDTO);
        try {
            Revenue revenue = revenueRepository.findById(id).get();
            logger.debug("Old Revenue: {}", revenue);
            revenue.setAmount(revenueDTO.getAmount());
            revenue.setDescription(revenueDTO.getDescription());
            revenue.setPaid(revenueDTO.getPaid());
            revenue.setPart(revenueDTO.getPart());
            revenue.setRevenueHead(revenueDTO.getRevenueHead());
            revenue.setStdClass(revenueDTO.getStdClass());
            revenue.setStudentType(revenueDTO.getStudentType());
            revenue.setWithForm(revenueDTO.getWithForm());
            try {
                logger.debug("Updated Revenue (Save): {}", revenue);
                revenueRepository.save(revenue);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Revenue not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }


    //delete by id
    public ResponseEntity<String> deleteRevenue(Long id) {
        logger.debug("---------> Delete Revenue By ID <---------");
        try {
            revenueRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Revenue not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }


}
