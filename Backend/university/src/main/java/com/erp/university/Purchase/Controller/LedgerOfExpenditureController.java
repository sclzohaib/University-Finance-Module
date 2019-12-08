package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Service.LedgerOfExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/ledgerOfExpenditure")
public class LedgerOfExpenditureController {
    @Autowired
    LedgerOfExpenditureService ledgerOfExpenditureService;

    //POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> SaveLedgerOfExpenditure(@Valid @RequestBody LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        return ledgerOfExpenditureService.saveLedgerOfExpenditure(ledgerOfExpenditureDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getLOE() {
        return ledgerOfExpenditureService.getLOE();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLOEById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return ledgerOfExpenditureService.getLOEById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateLOE(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        return ledgerOfExpenditureService.updateLOE(id, ledgerOfExpenditureDTO);
    }
}

