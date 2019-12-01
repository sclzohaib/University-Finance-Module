package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Service.AuthorizeSignatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/authozeSignatory")
public class AuthorizeSignatoryController {
    @Autowired
    AuthorizeSignatoryService authorizeSignatoryService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeSignatory (@RequestBody AuthorizeSignatoryDTO authorizeSignatoryDTO)
    {
        return authorizeSignatoryService.saveAuthorizedSignatory(authorizeSignatoryDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorizeSignatory>> getAuthorizeSignatory(){
        return authorizeSignatoryService.getAuthorizeSignatory();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorizeSignatory> getAuthorizeSignatoryById(@PathVariable("id") Long id){
        return authorizeSignatoryService.getAuthorizeSignatoryById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAuthorizeSignatory(@PathVariable("id") Long id, @RequestBody AuthorizeSignatoryDTO authorizeSignatoryDTO){
        return authorizeSignatoryService.updateAuthorizeSignatory(id, authorizeSignatoryDTO);

    }
}
