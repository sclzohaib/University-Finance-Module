package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.BankUserDTO;
import com.erp.university.Revenue.Services.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/bankUser")
public class BankUserController {
    @Autowired
    BankUserService bankUserService;
    //post
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveBankUser(@Valid @RequestBody BankUserDTO bankUserDTO)
    {
        return bankUserService.saveBankUser(bankUserDTO);
    }
}
