package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Model.LedgerOfExpenditure;
import com.erp.university.Purchase.Repository.LedgerOfExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerOfExpenditureService {

    @Autowired
    LedgerOfExpenditureRepository ledgerOfExpenditureRepository;

    //Save
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

    //Get All
    public ResponseEntity<List<LedgerOfExpenditure>> getAll(){
        List<LedgerOfExpenditure> ledgerOfExpenditures = ledgerOfExpenditureRepository.findAll();
        return new ResponseEntity<List<LedgerOfExpenditure>>(ledgerOfExpenditures, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<LedgerOfExpenditure> getById(Long id){
        LedgerOfExpenditure ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
        return new ResponseEntity<LedgerOfExpenditure>(ledgerOfExpenditure,HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> update(Long id, LedgerOfExpenditureDTO ledgerOfExpenditureDTO){
        LedgerOfExpenditure ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
        ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
        ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
        ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
        ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
        ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
