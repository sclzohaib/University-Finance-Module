package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.RoleDTO;
import com.erp.university.Purchase.Model.Role;
import com.erp.university.Purchase.Repository.RoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private static final Logger logger = LogManager.getLogger(PaymentVoucherService.class);
    @Autowired
    RoleRepository roleRepository;

    //save
    public ResponseEntity<String> saveRole(RoleDTO roleDTO) {
        logger.debug("--------->| Create Role: |<---------");
        logger.debug("RoleDTO: {}", roleDTO);
        try {
            Role role = new Role();
            role.setTitle(roleDTO.getTitle());
            role.setPermissions(roleDTO.getPermissions());
            logger.debug("Role (POST): {}", role);
            roleRepository.save(role);
            logger.debug("--------->| Role Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllRole() {
        logger.debug("--------->| Get All Roles |<---------");
        List<Role> roles;
        try {
            roles = roleRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (roles.isEmpty()) {
            logger.debug("No Role Record Found");
            return new ResponseEntity<>("No Role Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Roles Found Successfully |<---------");
            return new ResponseEntity<>(roles, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getRoleById(Long id) {
        logger.debug("--------->| Get Role By ID |<---------");
        Role role;
        try {
            role = roleRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Role Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Role Found Successfully |<---------");
        logger.debug("Role (GET): {}", role);
        return new ResponseEntity<>(role, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateRole(Long id, RoleDTO roleDTO) {
        logger.debug("---------> Update Role By ID <---------");
        logger.debug("ID: {}, RoleDTO: {}", id, roleDTO);
        try {
            Role role = roleRepository.findById(id).get();
            logger.debug("Old Role: {}", role);
            role.setPermissions(roleDTO.getPermissions());
            role.setTitle(roleDTO.getTitle());
            try {
                logger.debug("Updated Role (Save): {}", role);
                roleRepository.save(role);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Role Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Role Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
