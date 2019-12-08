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
        try {
            User user = new User();
            user.setStatus("Active");
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setContactNo(userDTO.getContactNo());
            user.setAddress(userDTO.getAddress());
            userRepository.save(user);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllUser() {
        List<User> users;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getUserById(Long id) {
        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateUser(Long id, UserDTO userDTO) {
        try {
            User user = userRepository.findById(id).get();
            user.setAddress(userDTO.getAddress());
            user.setContactNo(userDTO.getContactNo());
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setStatus(userDTO.getStatus());
            try {
                userRepository.save(user);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.FOUND);

    }


}
