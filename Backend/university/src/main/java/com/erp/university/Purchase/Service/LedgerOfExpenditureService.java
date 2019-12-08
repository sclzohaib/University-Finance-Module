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
    public ResponseEntity<String> saveLedgerOfExpenditure(LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        try {
            LedgerOfExpenditure ledgerOfExpenditure = new LedgerOfExpenditure();
            ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
            ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
            ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
            ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
            ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getLOE() {
        List<LedgerOfExpenditure> ledgerOfExpenditures;
        try {
            ledgerOfExpenditures = ledgerOfExpenditureRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ledgerOfExpenditures, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getLOEById(Long id) {
        LedgerOfExpenditure ledgerOfExpenditure;
        try {
            ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Ledger of Expenditure Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ledgerOfExpenditure, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateLOE(Long id, LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        try {
            LedgerOfExpenditure ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
            ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
            ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
            ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
            ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
            try {
                ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Ledger of Expenditure Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
