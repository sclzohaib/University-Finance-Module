package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UserTypeDTO;
import com.erp.university.Purchase.Model.UserType;
import com.erp.university.Purchase.Service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping (value ="/api/userType")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    //Post
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveUserType(@Valid @RequestBody UserTypeDTO userTypeDTO){
        return userTypeService.saveUserType(userTypeDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserType>> getAll(){
        return userTypeService.getAll();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserType> getById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id){
        return userTypeService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @Valid  @RequestBody UserTypeDTO userTypeDTO){
        return userTypeService.update(id, userTypeDTO);
    }
}
