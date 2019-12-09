package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Model.BudgetSheet;
import com.erp.university.Purchase.Repository.BudgetSheetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetSheetService {
    private static final Logger logger = LogManager.getLogger(BudgetSheetService.class);
    @Autowired
    BudgetSheetRepository budgetSheetRepository;

    //Save
    public ResponseEntity<String> saveBudgetSheet(BudgetSheetDTO budgetSheetDTO) {
        logger.debug("--------->| Create Budget Sheet: |<---------");
        logger.debug("Application DTO: {}", budgetSheetDTO);
        try {
            BudgetSheet budgetSheet = new BudgetSheet();
            budgetSheet.setBillAmount(budgetSheetDTO.getBillAmount());
            budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
            budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
            budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
            budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
            budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
            budgetSheet.setDate(budgetSheetDTO.getDate());
            logger.debug("Application (POST): {}", budgetSheet);
            budgetSheetRepository.save(budgetSheet);
            logger.debug("--------->| Application Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getBudgetSheet() {
        logger.debug("--------->| Get All Budget Sheets |<---------");
        List<BudgetSheet> budgetSheets;
        try {
            budgetSheets = budgetSheetRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (budgetSheets.isEmpty()) {
            logger.debug("No Budget Sheet Record Found");
            return new ResponseEntity<>("No Budget Sheet Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Budget Sheet Found Successfully |<---------");
            return new ResponseEntity<>(budgetSheets, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getBudgetSheetById(Long id) {
        logger.debug("--------->| Get Budget Sheet By ID |<---------");
        BudgetSheet budgetSheet;
        try {
            budgetSheet = budgetSheetRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Budget Sheet not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Budget Sheet Found Successfully |<---------");
        logger.debug("Application (GET): {}", budgetSheet);
        return new ResponseEntity<>(budgetSheet, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateBudgetSheet(Long id, BudgetSheetDTO budgetSheetDTO) {
        logger.debug("---------> Update Budget Sheet By ID<---------");
        logger.debug("ID: {}, BudgetSheetDTO: {}", id, budgetSheetDTO);
        try {
            BudgetSheet budgetSheet = budgetSheetRepository.findById(id).get();
            logger.debug("Old Budget Sheet: {}", budgetSheet);
            budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
            budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
            budgetSheet.setBillAmount(budgetSheet.getBalanceAvailable());
            budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
            budgetSheet.setDate(budgetSheetDTO.getDate());
            budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
            budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
            try {
                logger.debug("Updated Budget Sheet (Save): {}", budgetSheet);
                budgetSheetRepository.save(budgetSheet);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Budget Sheet not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Budget Sheet Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
