package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Service.AuthorizelvlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/authorizeLvl")
public class AuthorizelvlController {
    @Autowired
    AuthorizelvlService authorizelvlService;
    @RequestMapping(value = "/n", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeLvl(@RequestBody AuthorizeLvlDTO authorizeLvlDTO)
    {
        return authorizelvlService.saveAuthorizeLvl(authorizeLvlDTO);
    }


}
