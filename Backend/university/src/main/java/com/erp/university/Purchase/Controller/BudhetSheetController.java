package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Model.BudgetSheet;
import com.erp.university.Purchase.Service.BudgetSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/budgetSheet")
public class BudhetSheetController {
    @Autowired
    BudgetSheetService budgetSheetService;

    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveBudgetSheet(BudgetSheetDTO budgetSheetDTO)
    {
        return budgetSheetService.savebudgetSheet(budgetSheetDTO);
    }
    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<BudgetSheet>> getBudgetSheet(){
        return budgetSheetService.getBudgetSheet();
    }
    //Get By id
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<BudgetSheet> getBudgetSheetById(@PathVariable("id") Long id){
        return budgetSheetService.getBudgetSheetById(id);
    }
    //Update
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBudgetSheet(@PathVariable("id") Long id, @RequestBody BudgetSheetDTO budgetSheetDTO){
        return budgetSheetService.updateBudgetSheet(id, budgetSheetDTO);
    }
}
