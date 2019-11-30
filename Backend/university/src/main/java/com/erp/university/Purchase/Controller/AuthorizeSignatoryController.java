package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Service.AuthorizeSignatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/authozeSignatory")
public class AuthorizeSignatoryController {
    @Autowired
    AuthorizeSignatoryService authorizeSignatoryService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeSignatory (@RequestBody AuthorizeSignatoryDTO authorizeSignatoryDTO)
    {
        return authorizeSignatoryService.saveAuthorizedSignatory(authorizeSignatoryDTO);
    }
}
