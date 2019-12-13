package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.BankAccountDTO;
import com.erp.university.Revenue.Services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/bankAccount")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO)
    {
        return bankAccountService.saveBankAccount(bankAccountDTO);
    }

}
