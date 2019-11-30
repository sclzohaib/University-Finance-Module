package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Model.LedgerOfExpenditure;
import com.erp.university.Purchase.Repository.LedgerOfExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LedgerOfExpenditureService {

    @Autowired
    LedgerOfExpenditureRepository ledgerOfExpenditureRepository;
    public ResponseEntity<String> saveLedgerOfExpenditure(LedgerOfExpenditureDTO ledgerOfExpenditureDTO)
    {
        LedgerOfExpenditure ledgerOfExpenditure=new LedgerOfExpenditure();
        ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
        ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
        ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
        ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
        ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);
    }
}
