package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Model.BudgetSheet;
import com.erp.university.Purchase.Repository.BudgetSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BudgetSheetService {
    @Autowired
    BudgetSheetRepository budgetSheetRepository;
    public ResponseEntity<String> savebudgetSheet(BudgetSheetDTO budgetSheetDTO)
    {
        BudgetSheet budgetSheet=new BudgetSheet();
        budgetSheet.setBillAmount(budgetSheetDTO.getBillAmount());
        budgetSheet.setBlnceAvail(budgetSheetDTO.getBlnceAvail());
        budgetSheet.setBudgetAllocation(budgetSheetDTO.getBudgetAllocation());
        budgetSheet.setOverExp(budgetSheetDTO.getOverExp());
        budgetSheet.setTotalExpense(budgetSheetDTO.getTotalExpense());
        budgetSheet.setUpToDateExp(budgetSheetDTO.getUpToDateExp());
        budgetSheet.setDate(budgetSheetDTO.getDate());
        budgetSheetRepository.save(budgetSheet);
        return new ResponseEntity<String>("Addded Successfully", HttpStatus.CREATED);
    }
}
