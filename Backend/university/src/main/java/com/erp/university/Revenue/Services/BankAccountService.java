package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.BankAccountDTO;
import com.erp.university.Revenue.Model.BankAccount;
import com.erp.university.Revenue.Repository.BankAccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);
    @Autowired
    BankAccountRepository bankAccountRepository;

    //Save
    public ResponseEntity<String> saveBankAccount(BankAccountDTO bankAccountDTO) {
        logger.debug("--------->| Create Bank Account: |<---------");
        logger.debug("BankAccountDTO: {}", bankAccountDTO);
        try {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
            bankAccount.setName(bankAccountDTO.getName());
            logger.debug("Admin (POST): {}", bankAccount);
            bankAccountRepository.save(bankAccount);
            logger.debug("--------->| Admin Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllBankAccount() {
        logger.debug("--------->| Get All Bank Accounts |<---------");
        List<BankAccount> bankAccounts;
        try {
            bankAccounts = bankAccountRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (bankAccounts.isEmpty()) {
            logger.debug("No Bank Account Record Found");
            return new ResponseEntity<>("No Bank Account Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Bank Accounts Found Successfully |<---------");
            return new ResponseEntity<>(bankAccounts, HttpStatus.FOUND);
        }
    }


    //Get By id
    public ResponseEntity<?> getBankAccountById(Long id) {
        logger.debug("--------->| Get Bank Account By ID |<---------");
        BankAccount bankAccount;
        try {
            bankAccount = bankAccountRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Bank Account not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank Account Found Successfully |<---------");
        logger.debug("Bank Account (GET): {}", bankAccount);
        return new ResponseEntity<>(bankAccount, HttpStatus.FOUND);
    }


    //Update by id
    public ResponseEntity<String> updateBankAccount(Long id, BankAccountDTO bankAccountDTO) {
        logger.debug("---------> Update Bank Account By ID <---------");
        logger.debug("ID: {}, BankAccountDTO: {}", id, bankAccountDTO);
        try {
            BankAccount bankAccount = bankAccountRepository.findById(id).get();
            logger.debug("Old Bank Account: {}", bankAccount);
            bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
            bankAccount.setName(bankAccountDTO.getName());
            try {
                logger.debug("Updated Bank Account (Save): {}", bankAccount);
                bankAccountRepository.save(bankAccount);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Bank Account not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank Account Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteBankAccount(Long id) {
        logger.debug("---------> Delete Bank Account By ID <---------");
        try {
            bankAccountRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Bank Account not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank Account Deleted Successfully |<---------");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
