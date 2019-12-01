package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserTypeDTO;
import com.erp.university.Purchase.Model.UserType;
import com.erp.university.Purchase.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    //Save
    public ResponseEntity<String> saveUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setUserType(userTypeDTO.getUserType());
        userTypeRepository.save(userType);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<List<UserType>> getAll(){
        List<UserType> userTypes = userTypeRepository.findAll();
        return new ResponseEntity<List<UserType>>(userTypes, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<UserType> getById(Long id){
        UserType userType = userTypeRepository.findById(id).get();
        return new ResponseEntity<UserType>(userType, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> update(Long id, UserTypeDTO userTypeDTO){
        UserType userType = userTypeRepository.findById(id).get();
        userType.setUserType(userTypeDTO.getUserType());
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
