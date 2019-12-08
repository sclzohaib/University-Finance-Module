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
    public ResponseEntity<String> saveAuthorizeLvl(AuthorizeLvlDTO authorizeLvlDTO) {
        try {
            AuthorizeLvl authorizeLvl = new AuthorizeLvl();
            authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
            authorizeLvlRepository.save(authorizeLvl);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.CREATED);
    }

    //Get all authorize level
    public ResponseEntity<?> getAuthorizeLvl() {
        List<AuthorizeLvl> authorizeLvls;
        try {
            authorizeLvls = authorizeLvlRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorizeLvls, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getAuthorizeLvlById(Long id) {
        AuthorizeLvl authorizeLvl;
        try {
            authorizeLvl = authorizeLvlRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Authorize Level not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorizeLvl, HttpStatus.FOUND);
    }

    //Update Authorized Level
    public ResponseEntity<String> updateAuthorizeLvl(Long id, AuthorizeLvlDTO authorizeLvlDTO) {
        try {
            AuthorizeLvl authorizeLvl = authorizeLvlRepository.findById(id).get();
            authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
            try {
                authorizeLvlRepository.save(authorizeLvl);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Authorize Level not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
