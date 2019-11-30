package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Repository.AuthorizeLvlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizelvlService {

    @Autowired
    AuthorizeLvlRepository authorizeLvlRepository;

public ResponseEntity<String> saveAuthorizeLvl(AuthorizeLvlDTO authorizeLvlDTO){
    AuthorizeLvl authorizeLvl =new AuthorizeLvl();
    authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
    authorizeLvlRepository.save(authorizeLvl);
    return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);
}


}
