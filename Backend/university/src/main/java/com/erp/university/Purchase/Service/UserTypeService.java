package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserTypeDTO;
import com.erp.university.Purchase.Model.UserType;
import com.erp.university.Purchase.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;
    public ResponseEntity<String> saveUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setUserType(userTypeDTO.getUserType());
        userTypeRepository.save(userType);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

    }
}
