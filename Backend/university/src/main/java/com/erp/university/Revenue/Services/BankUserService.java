package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.BankUserDTO;
import com.erp.university.Revenue.Model.BankUser;
import com.erp.university.Revenue.Repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BankUserService {
    @Autowired
    BankUserRepository bankUserRepository;
    //save
    public ResponseEntity<String> saveBankUser(BankUserDTO bankUserDTO)
    {
        try {
            BankUser bankUser=new BankUser();
            bankUser.setBankId(bankUserDTO.getBankId());
            bankUser.setPassword(bankUserDTO.getPassword());
            bankUserRepository.save(bankUser);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added successfully",HttpStatus.CREATED);
    }
}
