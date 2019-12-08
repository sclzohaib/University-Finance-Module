package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Service.AuthorizeSignatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/authorizeSignatory")
public class AuthorizeSignatoryController {
    @Autowired
    AuthorizeSignatoryService authorizeSignatoryService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeSignatory(@Valid @RequestBody AuthorizeSignatoryDTO authorizeSignatoryDTO) {
        return authorizeSignatoryService.saveAuthorizedSignatory(authorizeSignatoryDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorizeSignatory() {
        return authorizeSignatoryService.getAuthorizeSignatory();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorizeSignatoryById(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id) {
        return authorizeSignatoryService.getAuthorizeSignatoryById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAuthorizeSignatory(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id, @Valid @RequestBody AuthorizeSignatoryDTO authorizeSignatoryDTO) {
        return authorizeSignatoryService.updateAuthorizeSignatory(id, authorizeSignatoryDTO);

    }
}
