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

        AuthorizeSignatory authorizeSignatory = new AuthorizeSignatory();
        authorizeSignatory.setLvlId(authorizedSignatoryDTO.getLvlId());
        authorizeSignatoryRepository.save(authorizeSignatory);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<List<AuthorizeSignatory>> getAuthorizeSignatory() {
        List<AuthorizeSignatory> authorizeSignatories = authorizeSignatoryRepository.findAll();
        return new ResponseEntity<List<AuthorizeSignatory>>(authorizeSignatories, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<AuthorizeSignatory> getAuthorizeSignatoryById(Long id) {
        AuthorizeSignatory authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
        return new ResponseEntity<AuthorizeSignatory>(authorizeSignatory, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateAuthorizeSignatory(Long id, AuthorizeSignatoryDTO authorizeSignatoryDTO) {
        AuthorizeSignatory authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
        authorizeSignatory.setLvlId(authorizeSignatoryDTO.getLvlId());
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
