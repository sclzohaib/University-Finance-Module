package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.BankUserDTO;
import com.erp.university.Revenue.Services.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/revenue/bankUser")
public class BankUserController {
    @Autowired
    BankUserService bankUserService;

    //post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveBankUser(@Valid @RequestBody BankUserDTO bankUserDTO) {
        return bankUserService.saveBankUser(bankUserDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBankUser() {
        return bankUserService.getAllBankUser();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBankUserById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return bankUserService.getBankUserById(id);
    }


    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankUser(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody BankUserDTO bankUserDTO) {
        return bankUserService.updateBankUser(id, bankUserDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBankUser(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return bankUserService.deleteBankUser(id);
    }
}
