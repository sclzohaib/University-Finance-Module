package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.LedgerOfExpenditureDTO;
import com.erp.university.Purchase.Model.LedgerOfExpenditure;
import com.erp.university.Purchase.Repository.LedgerOfExpenditureRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerOfExpenditureService {

    private static final Logger logger = LogManager.getLogger(LedgerOfExpenditureService.class);
    @Autowired
    LedgerOfExpenditureRepository ledgerOfExpenditureRepository;

    //Save
    public ResponseEntity<String> saveLedgerOfExpenditure(LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        logger.debug("--------->| Create Ledger Of Expenditure: |<---------");
        logger.debug("LedgerOfExpenditureDTO: {}", ledgerOfExpenditureDTO);
        try {
            LedgerOfExpenditure ledgerOfExpenditure = new LedgerOfExpenditure();
            ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
            ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
            ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
            ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
            logger.debug("Ledger Of Expenditure (POST): {}", ledgerOfExpenditure);
            ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
            logger.debug("--------->| Ledger Of Expenditure Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getLOE() {
        logger.debug("--------->| Get All Ledger Of Expenditures |<---------");
        List<LedgerOfExpenditure> ledgerOfExpenditures;
        try {
            ledgerOfExpenditures = ledgerOfExpenditureRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (ledgerOfExpenditures.isEmpty()) {
            logger.debug("No Ledger Of Expenditures Record Found");
            return new ResponseEntity<>("No Ledger Of Expenditures Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Ledger Of Expenditures Found Successfully |<---------");
            return new ResponseEntity<>(ledgerOfExpenditures, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getLOEById(Long id) {
        logger.debug("--------->| Get Ledger of Expenditure By ID |<---------");
        LedgerOfExpenditure ledgerOfExpenditure;
        try {
            ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Ledger of Expenditure Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Ledger of Expenditure Found Successfully |<---------");
        logger.debug("Ledger of Expenditure (GET): {}", ledgerOfExpenditure);
        return new ResponseEntity<>(ledgerOfExpenditure, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateLOE(Long id, LedgerOfExpenditureDTO ledgerOfExpenditureDTO) {
        logger.debug("---------> Update Ledger of Expenditure By ID<---------");
        logger.debug("ID: {}, LedgerOfExpenditureDTO: {}", id, ledgerOfExpenditureDTO);
        try {
            LedgerOfExpenditure ledgerOfExpenditure = ledgerOfExpenditureRepository.findById(id).get();
            logger.debug("Old Ledger of Expenditure: {}", ledgerOfExpenditure);
            ledgerOfExpenditure.setBalance(ledgerOfExpenditureDTO.getBalance());
            ledgerOfExpenditure.setDate(ledgerOfExpenditureDTO.getDate());
            ledgerOfExpenditure.setDebitAmount(ledgerOfExpenditureDTO.getDebitAmount());
            ledgerOfExpenditure.setParticulars(ledgerOfExpenditureDTO.getParticulars());
            try {
                logger.debug("Updated Ledger of Expenditure (Save): {}", ledgerOfExpenditure);
                ledgerOfExpenditureRepository.save(ledgerOfExpenditure);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Ledger of Expenditure Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Ledger of Expenditure Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
