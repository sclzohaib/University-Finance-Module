package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Service.BudgetSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/budgetSheet")
public class BudhetSheetController {
    @Autowired
    BudgetSheetService budgetSheetService;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveBudgetSheet(BudgetSheetDTO budgetSheetDTO)
    {
        return budgetSheetService.savebudgetSheet(budgetSheetDTO);
    }
}
