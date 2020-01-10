package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Service.AuthorizelvlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/authorizeLvl")
public class AuthorizelvlController {
    @Autowired
    AuthorizelvlService authorizelvlService;

    //Post call
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveAuthorizeLvl(@RequestBody AuthorizeLvlDTO authorizeLvlDTO) {
        return authorizelvlService.saveAuthorizeLvl(authorizeLvlDTO);
    }


    //Get all Call
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorizeLvl() {
        return authorizelvlService.getAuthorizeLvl();

    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorizeLvlById(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id) {
        return authorizelvlService.getAuthorizeLvlById(id);
    }

    //Put call
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAuthorizeLvl(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id, @Valid @RequestBody AuthorizeLvlDTO authorizeLvlDTO) {
        return authorizelvlService.updateAuthorizeLvl(id, authorizeLvlDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAuthorizeLvl(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return authorizelvlService.deleteAuthorizeLvl(id);
    }
}
