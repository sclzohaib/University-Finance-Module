package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Service.AuthorizelvlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/authorizeLvl")
public class AuthorizelvlController {
    @Autowired
    AuthorizelvlService authorizelvlService;

    //Post call
    @RequestMapping(value = "/n", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeLvl(@RequestBody AuthorizeLvlDTO authorizeLvlDTO)
    {
        return authorizelvlService.saveAuthorizeLvl(authorizeLvlDTO);
    }


    //Get all Call
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorizeLvl>> getAuthorizeLvl(){
        return authorizelvlService.getAuthorizeLvl();

    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorizeLvl> getAuthorizeLvlById(@PathVariable("id") Long id){
        return authorizelvlService.getAuthorizeLvlById(id);
    }

    //Put call
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAuthorizeLvl(Long id, AuthorizeLvlDTO authorizeLvlDTO){
        return authorizelvlService.updateAuthorizeLvl(id, authorizeLvlDTO);
    }

}
