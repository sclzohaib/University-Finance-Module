package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Repository.AuthorizeSignatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeSignatoryService {
    @Autowired
    AuthorizeSignatoryRepository authorizeSignatoryRepository;

public ResponseEntity<String> saveAuthorizedSignatory(AuthorizeSignatoryDTO authorizedSignatoryDTO){

    AuthorizeSignatory authorizeSignatory =new AuthorizeSignatory();
    authorizeSignatory.setLvlId(authorizedSignatoryDTO.getLvlId());
    authorizeSignatoryRepository.save(authorizeSignatory);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
}

}
