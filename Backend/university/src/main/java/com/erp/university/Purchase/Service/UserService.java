package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Save
    public ResponseEntity<String> saveUser(UserDTO userDTO) {
        User user = new User();
        user.setStatus("Active");
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setContactNo(userDTO.getContactNo());
        user.setAddress(userDTO.getAddress());
        userRepository.save(user);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).get();
        user.setAddress(userDTO.getAddress());
        user.setContactNo(userDTO.getContactNo());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        userRepository.save(user);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.FOUND);

    }


}
