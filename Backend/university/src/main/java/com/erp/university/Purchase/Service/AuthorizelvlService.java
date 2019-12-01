package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Repository.AuthorizeLvlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizelvlService {

    @Autowired
    AuthorizeLvlRepository authorizeLvlRepository;

    //Save Authorize Level
public ResponseEntity<String> saveAuthorizeLvl(AuthorizeLvlDTO authorizeLvlDTO){
    AuthorizeLvl authorizeLvl =new AuthorizeLvl();
    authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
    authorizeLvlRepository.save(authorizeLvl);
    return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);
}

//Get all authorize level
    public ResponseEntity<List<AuthorizeLvl>> getAuthorizeLvl(){
    List<AuthorizeLvl> authorizeLvls = authorizeLvlRepository.findAll();
return new ResponseEntity<List<AuthorizeLvl>>(authorizeLvls,HttpStatus.FOUND);
}

//Get by id
    public ResponseEntity<AuthorizeLvl> getAuthorizeLvlById(Long id){
    AuthorizeLvl authorizeLvl = authorizeLvlRepository.findById(id).get();
    return new ResponseEntity<AuthorizeLvl>(authorizeLvl,HttpStatus.FOUND);
    }

    //Update Authorized Level
    public ResponseEntity<String> updateAuthorizeLvl(Long id, AuthorizeLvlDTO authorizeLvlDTO){
    AuthorizeLvl authorizeLvl = authorizeLvlRepository.findById(id).get();
    authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
    authorizeLvlRepository.save(authorizeLvl);
    return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

}
