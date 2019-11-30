package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<String> saveUser(UserDTO userDTO)
    {
        User user=new User();
        userRepository.save(user);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

    }


}
