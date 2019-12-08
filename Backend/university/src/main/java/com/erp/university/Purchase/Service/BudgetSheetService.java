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
        BudgetSheet budgetSheet = new BudgetSheet();
        budgetSheet.setBillAmount(budgetSheetDTO.getBillAmount());
        budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
        budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
        budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
        budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
        budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
        budgetSheet.setDate(budgetSheetDTO.getDate());
        budgetSheetRepository.save(budgetSheet);
        return new ResponseEntity<String>("Addded Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<List<BudgetSheet>> getBudgetSheet() {
        List<BudgetSheet> budgetSheets = budgetSheetRepository.findAll();
        return new ResponseEntity<List<BudgetSheet>>(budgetSheets, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<BudgetSheet> getBudgetSheetById(Long id) {
        BudgetSheet budgetSheet = budgetSheetRepository.findById(id).get();
        return new ResponseEntity<BudgetSheet>(budgetSheet, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateBudgetSheet(Long id, BudgetSheetDTO budgetSheetDTO) {
        BudgetSheet budgetSheet = budgetSheetRepository.findById(id).get();
        budgetSheet.setUptoDateExp(budgetSheetDTO.getUptoDateExp());
        budgetSheet.setBalanceAvailable(budgetSheetDTO.getBalanceAvailable());
        budgetSheet.setBillAmount(budgetSheet.getBalanceAvailable());
        budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
        budgetSheet.setDate(budgetSheetDTO.getDate());
        budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
        budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
        budgetSheetRepository.save(budgetSheet);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
