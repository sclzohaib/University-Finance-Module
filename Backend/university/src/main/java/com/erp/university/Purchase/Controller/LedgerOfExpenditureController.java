package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Service.LedgerOfExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LedgerOfExpenditureController {
@Autowired
    LedgerOfExpenditureService ledgerOfExpenditureService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> SaveLedgerOfExpenditure(@RequestBody LedgerOfExpenditureDTO ledgerOfExpenditureDTO)
{
    return ledgerOfExpenditureService.saveLedgerOfExpenditure(ledgerOfExpenditureDTO);
}
}

