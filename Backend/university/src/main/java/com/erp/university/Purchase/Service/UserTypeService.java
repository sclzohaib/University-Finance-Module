package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserTypeDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Model.UserType;
import com.erp.university.Purchase.Repository.UserTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
    private static final Logger logger = LogManager.getLogger(UserTypeService.class);
    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    UserServiceImpl userService;

    //Save
    public ResponseEntity<String> saveUserType(UserTypeDTO userTypeDTO) {
        logger.debug("--------->| Create User Type: |<---------");
        logger.debug("UserTypeDTO: {}", userTypeDTO);
        try {
            UserType userType = new UserType();
            userType.setUserType(userTypeDTO.getUserType());
            logger.debug("User Type (POST): {}", userType);
            userTypeRepository.save(userType);
            logger.debug("--------->| User Type Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllUserType() {
        logger.debug("--------->| Get All User Types |<---------");
        List<UserType> userTypes;
        try {
            userTypes = userTypeRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (userTypes.isEmpty()) {
            logger.debug("No User Type Record Found");
            return new ResponseEntity<>("{\"No User Type Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| User Types Found Successfully |<---------");
            return new ResponseEntity<>(userTypes, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getUserTypeById(Long id) {
        logger.debug("--------->| Get User Type By ID |<---------");
        UserType userType;
        try {
            userType = userTypeRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Type Found Successfully |<---------");
        logger.debug("User Type (GET): {}", userType);
        return new ResponseEntity<>(userType, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateUserType(Long id, UserTypeDTO userTypeDTO) {
        logger.debug("---------> Update User Type By ID <---------");
        logger.debug("ID: {}, UserTypeDTO: {}", id, userTypeDTO);
        try {
            UserType userType = userTypeRepository.findById(id).get();
            logger.debug("Old User Type: {}", userType);
            userType.setUserType(userTypeDTO.getUserType());
            try {
                logger.debug("Updated User Type (Save): {}", userType);
                userTypeRepository.save(userType);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Type Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }
    //delete by id
    public ResponseEntity<String> deleteUserType(Long id) {
        logger.debug("---------> Delete User Type By ID <---------");
        try {
            List<User> users = userTypeRepository.findById(id).get().getUsers();
            users.forEach(user -> {
                userService.deleteUser(user.getId());
            });
            userTypeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"User Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| User Type Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
