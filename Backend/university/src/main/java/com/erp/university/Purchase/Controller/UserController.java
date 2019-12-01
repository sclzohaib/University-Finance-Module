package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
            public ResponseEntity<String> saveUser(UserDTO userDTO)
    {
        return userService.saveUser(userDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll(){
        return userService.getAll();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id , @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }
}
