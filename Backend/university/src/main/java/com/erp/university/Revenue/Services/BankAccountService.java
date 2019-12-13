package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.BankAccountDTO;
import com.erp.university.Revenue.Model.BankAccount;
import com.erp.university.Revenue.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;
    public ResponseEntity<String> saveBankAccount(BankAccountDTO bankAccountDTO)
    {
        try
        {
            BankAccount bankAccount=new BankAccount();
            bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
            bankAccount.setName(bankAccountDTO.getName());
            bankAccountRepository.save(bankAccount);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }

    }
