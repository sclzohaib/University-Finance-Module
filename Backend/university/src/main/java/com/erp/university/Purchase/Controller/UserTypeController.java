package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UserTypeDTO;
import com.erp.university.Purchase.Service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value ="/api/userType")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveUserType(UserTypeDTO userTypeDTO){
        return userTypeService.saveUserType(userTypeDTO);
    }
}
