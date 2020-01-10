package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "appuserService")
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    //Save
    public ResponseEntity<String> saveUser(UserDTO userDTO) {
        logger.debug("--------->| Create User: |<---------");
        logger.debug("UserDTO: {}", userDTO);
        try {
            User user = new User();
            user.setStatus("ACTIVE");
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setContactNo(userDTO.getContactNo());
            user.setAddress(userDTO.getAddress());
            user.setAuthorizeSignatory(userDTO.getAuthorizeSignatory());
            user.setDepartment(userDTO.getDepartment());
            user.setUserType(userDTO.getUserType());
            user.setRoles(userDTO.getRoles());
            logger.debug("User (POST): {}", user);
            userRepository.save(user);
            logger.debug("--------->| User Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllUser() {
        logger.debug("--------->| Get All Users |<---------");
        List<User> users;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (users.isEmpty()) {
            logger.debug("No User Record Found");
            return new ResponseEntity<>("{\"No User Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Users Found Successfully |<---------");
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getUserById(Long id) {
        logger.debug("--------->| Get User By ID |<---------");
        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Found Successfully |<---------");
        logger.debug("User (GET): {}", user);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateUser(Long id, UserDTO userDTO) {
        logger.debug("---------> Update User By ID <---------");
        logger.debug("ID: {}, UserDTO: {}", id, userDTO);
        try {
            User user = userRepository.findById(id).get();
            logger.debug("Old User: {}", user);
            user.setAddress(userDTO.getAddress());
            user.setContactNo(userDTO.getContactNo());
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setStatus(userDTO.getStatus());
            user.setRoles(userDTO.getRoles());
            user.setDepartment(userDTO.getDepartment());
            user.setUserType(userDTO.getUserType());
            user.setAuthorizeSignatory(userDTO.getAuthorizeSignatory());
            try {
                logger.debug("Updated User (Save): {}", user);
                userRepository.save(user);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);

    }

    //delete by id
    public ResponseEntity<String> deleteUser(Long id) {
        logger.debug("---------> Delete User By ID <---------");
        try {
            userRepository.deleteROLE_USERSByUsersId(id);
            userRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }

}
