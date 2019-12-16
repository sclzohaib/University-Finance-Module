package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.BankAccountDTO;
import com.erp.university.Revenue.Services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/revenue/bankAccount")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO) {
        return bankAccountService.saveBankAccount(bankAccountDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBankAccount() {
        return bankAccountService.getAllBankAccount();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBankAccountById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankAccount(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody BankAccountDTO bankAccountDTO) {
        return bankAccountService.updateBankAccount(id, bankAccountDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBankAccount(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return bankAccountService.deleteBankAccount(id);
    }

}
