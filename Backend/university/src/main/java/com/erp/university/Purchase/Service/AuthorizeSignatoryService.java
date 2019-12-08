package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Repository.AuthorizeSignatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizeSignatoryService {
    @Autowired
    AuthorizeSignatoryRepository authorizeSignatoryRepository;

    //Save
    public ResponseEntity<String> saveAuthorizedSignatory(AuthorizeSignatoryDTO authorizedSignatoryDTO) {

        try {
            AuthorizeSignatory authorizeSignatory = new AuthorizeSignatory();
            authorizeSignatory.setLvlId(authorizedSignatoryDTO.getLvlId());
            authorizeSignatoryRepository.save(authorizeSignatory);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAuthorizeSignatory() {
        List<AuthorizeSignatory> authorizeSignatories;
        try {
            authorizeSignatories = authorizeSignatoryRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorizeSignatories, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getAuthorizeSignatoryById(Long id) {
        AuthorizeSignatory authorizeSignatory;
        try {
            authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Authorize Signatory not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorizeSignatory, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateAuthorizeSignatory(Long id, AuthorizeSignatoryDTO authorizeSignatoryDTO) {
        try {
            AuthorizeSignatory authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
            authorizeSignatory.setLvlId(authorizeSignatoryDTO.getLvlId());
            try {
                authorizeSignatoryRepository.save(authorizeSignatory);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went worng", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Authorize Signatory not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
