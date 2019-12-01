package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Model.LedgerOfExpenditure;
import com.erp.university.Purchase.Service.LedgerOfExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  (value= "/api/ledgerOfExpenditure")
public class LedgerOfExpenditureController {
@Autowired
    LedgerOfExpenditureService ledgerOfExpenditureService;

//POST
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> SaveLedgerOfExpenditure(@RequestBody LedgerOfExpenditureDTO ledgerOfExpenditureDTO)
{
    return ledgerOfExpenditureService.saveLedgerOfExpenditure(ledgerOfExpenditureDTO);
}

//Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<LedgerOfExpenditure>> getAll(){
    return ledgerOfExpenditureService.getAll();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LedgerOfExpenditure> getById(@PathVariable("id") Long id){
    return ledgerOfExpenditureService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody LedgerOfExpenditureDTO ledgerOfExpenditureDTO){
    return ledgerOfExpenditureService.update(id, ledgerOfExpenditureDTO);
    }
 }

