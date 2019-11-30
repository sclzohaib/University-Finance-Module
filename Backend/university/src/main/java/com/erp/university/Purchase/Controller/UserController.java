package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
            public ResponseEntity<String> saveUser(UserDTO userDTO)
    {
        return userService.saveUser(userDTO);
    }
}
