package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PermissionDTO;
import com.erp.university.Purchase.Model.Permission;
import com.erp.university.Purchase.Repository.PermissionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    private static final Logger logger = LogManager.getLogger(PaymentVoucherService.class);

    @Autowired
    PermissionRepository permissionRepository;

    //Save
    public ResponseEntity<String> savePermission(PermissionDTO permissionDTO) {
        logger.debug("--------->| Create Permission: |<---------");
        logger.debug("PermissionDTO: {}", permissionDTO);
        try {
            Permission permission = new Permission();
            permission.setConstName(permissionDTO.getConstName());
            permission.setTitle(permissionDTO.getTitle());
            logger.debug("Permission (POST): {}", permission);
            permissionRepository.save(permission);
            logger.debug("--------->| Permission Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getAllPermission() {
        logger.debug("--------->| Get All Permissions |<---------");
        List<Permission> permissions;
        try {
            permissions = permissionRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (permissions.isEmpty()) {
            logger.debug("No Permission Record Found");
            return new ResponseEntity<>("No Permission Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Permissions Found Successfully |<---------");
            return new ResponseEntity<>(permissions, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getPermissionById(Long id) {
        logger.debug("--------->| Get Permission By ID |<---------");
        Permission permission;
        try {
            permission = permissionRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Permission Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Permission Found Successfully |<---------");
        logger.debug("Permission (GET): {}", permission);
        return new ResponseEntity<>(permission, HttpStatus.FOUND);
    }

    //Update by id
    public ResponseEntity<String> updatePermission(Long id, PermissionDTO permissionDTO) {
        logger.debug("---------> Update Permission By ID <---------");
        logger.debug("ID: {}, PermissionDTO: {}", id, permissionDTO);
        try {
            Permission permission = permissionRepository.findById(id).get();
            logger.debug("Old Permission: {}", permission);
            permission.setConstName(permissionDTO.getConstName());
            permission.setTitle(permissionDTO.getTitle());
            try {
                logger.debug("Updated Permission (Save): {}", permission);
                permissionRepository.save(permission);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Permission Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Permission Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
