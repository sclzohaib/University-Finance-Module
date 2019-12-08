package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        return userService.getAllUser();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return userService.getUserById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
}
