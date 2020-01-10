package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.BankUserDTO;
import com.erp.university.Revenue.Model.BankUser;
import com.erp.university.Revenue.Repository.BankUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUserService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    BankUserRepository bankUserRepository;

    //save
    public ResponseEntity<String> saveBankUser(BankUserDTO bankUserDTO) {
        logger.debug("--------->| Create Bank User: |<---------");
        logger.debug("BankUserDTO: {}", bankUserDTO);
        try {
            BankUser bankUser = new BankUser();
            bankUser.setBankId(bankUserDTO.getBankId());
            bankUser.setPassword(bankUserDTO.getPassword());
            logger.debug("Bank User (POST): {}", bankUser);
            bankUserRepository.save(bankUser);
            logger.debug("--------->| Bank User Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added successfully\":1}", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllBankUser() {
        logger.debug("--------->| Get All Bank Users |<---------");
        List<BankUser> bankUsers;
        try {
            bankUsers = bankUserRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (bankUsers.isEmpty()) {
            logger.debug("No Bank User Record Found");
            return new ResponseEntity<>("{\"No Bank User Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Bank Users Found Successfully |<---------");
            return new ResponseEntity<>(bankUsers, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getBankUserById(Long id) {
        logger.debug("--------->| Get Bank User By ID |<---------");
        BankUser bankUser;
        try {
            bankUser = bankUserRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Bank User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank User Found Successfully |<---------");
        logger.debug("Bank User (GET): {}", bankUser);
        return new ResponseEntity<>(bankUser, HttpStatus.FOUND);
    }

    //Update by id
    public ResponseEntity<String> updateBankUser(Long id, BankUserDTO bankUserDTO) {
        logger.debug("---------> Update Bank User By ID <---------");
        logger.debug("ID: {}, BankUserDTO: {}", id, bankUserDTO);
        try {
            BankUser bankUser = bankUserRepository.findById(id).get();
            logger.debug("Old Bank User: {}", bankUser);
            bankUser.setBankId(bankUserDTO.getBankId());
            bankUser.setPassword(bankUserDTO.getPassword());
            try {
                logger.debug("Updated Bank User (Save): {}", bankUser);
                bankUserRepository.save(bankUser);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Bank User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank User Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteBankUser(Long id) {
        logger.debug("---------> Delete Bank User By ID <---------");
        try {
            bankUserRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Bank User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Bank User Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
