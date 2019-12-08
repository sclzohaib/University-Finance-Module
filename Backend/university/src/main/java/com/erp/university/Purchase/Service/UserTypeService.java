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
        try {
            UserType userType = new UserType();
            userType.setUserType(userTypeDTO.getUserType());
            userTypeRepository.save(userType);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllUserType() {
        List<UserType> userTypes;
        try {
            userTypes = userTypeRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTypes, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getUserTypeById(Long id) {
        UserType userType;
        try {
            userType = userTypeRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("User Type not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userType, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateUserType(Long id, UserTypeDTO userTypeDTO) {
        try {
            UserType userType = userTypeRepository.findById(id).get();
            userType.setUserType(userTypeDTO.getUserType());
            try {
                userTypeRepository.save(userType);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("User Type not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
