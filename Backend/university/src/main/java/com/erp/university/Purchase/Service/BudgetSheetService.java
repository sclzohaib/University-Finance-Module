package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Model.BudgetSheet;
import com.erp.university.Purchase.Repository.BudgetSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetSheetService {
    @Autowired
    BudgetSheetRepository budgetSheetRepository;

    //Save
    public ResponseEntity<String> saveBudgetSheet(BudgetSheetDTO budgetSheetDTO) {
        try {
            BudgetSheet budgetSheet = new BudgetSheet();
            budgetSheet.setBillAmount(budgetSheetDTO.getBillAmount());
            budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
            budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
            budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
            budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
            budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
            budgetSheet.setDate(budgetSheetDTO.getDate());
            budgetSheetRepository.save(budgetSheet);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getBudgetSheet() {
        List<BudgetSheet> budgetSheets;
        try {
            budgetSheets = budgetSheetRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(budgetSheets, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getBudgetSheetById(Long id) {
        BudgetSheet budgetSheet;
        try {
            budgetSheet = budgetSheetRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Budget Sheet not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(budgetSheet, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateBudgetSheet(Long id, BudgetSheetDTO budgetSheetDTO) {
        try {
            BudgetSheet budgetSheet = budgetSheetRepository.findById(id).get();
            budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
            budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
            budgetSheet.setBillAmount(budgetSheet.getBalanceAvailable());
            budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
            budgetSheet.setDate(budgetSheetDTO.getDate());
            budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
            budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
            try {
                budgetSheetRepository.save(budgetSheet);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Budget Sheet not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
