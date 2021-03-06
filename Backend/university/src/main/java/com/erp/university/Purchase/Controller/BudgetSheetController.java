package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.BudgetSheetDTO;
import com.erp.university.Purchase.Service.BudgetSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/budgetSheet")
public class BudgetSheetController {
    @Autowired
    BudgetSheetService budgetSheetService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveBudgetSheet(@Valid @RequestBody BudgetSheetDTO budgetSheetDTO) {
        return budgetSheetService.saveBudgetSheet(budgetSheetDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getBudgetSheet() {
        return budgetSheetService.getBudgetSheet();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBudgetSheetById(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id) {
        return budgetSheetService.getBudgetSheetById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBudgetSheet(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id, @Valid @RequestBody BudgetSheetDTO budgetSheetDTO) {
        return budgetSheetService.updateBudgetSheet(id, budgetSheetDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBudgetSheet(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return budgetSheetService.deleteBudgetSheet(id);
    }
}
