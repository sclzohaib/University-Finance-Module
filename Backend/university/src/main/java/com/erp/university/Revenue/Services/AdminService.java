package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.AdminDTO;
import com.erp.university.Revenue.Model.Admin;
import com.erp.university.Revenue.Repository.AdminRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    AdminRepository adminRepository;

    //Save
    public ResponseEntity<String> saveAdmin(AdminDTO adminDTO) {
        logger.debug("--------->| Create Admin: |<---------");
        logger.debug("AdminDTO: {}", adminDTO);
        try {
            Admin admin = new Admin();
            admin.setAdminId(adminDTO.getAdminId());
            admin.setPassword(adminDTO.getPassword());
            logger.debug("Admin (POST): {}", admin);
            adminRepository.save(admin);
            logger.debug("--------->| Admin Created |<---------");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<?> getAllAdmin() {
        logger.debug("--------->| Get All Admins |<---------");
        List<Admin> admins;
        try {
            admins = adminRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (admins.isEmpty()) {
            logger.debug("No Admin Record Found");
            return new ResponseEntity<>("{\"No Admin Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Admins Found Successfully |<---------");
            return new ResponseEntity<>(admins, HttpStatus.FOUND);
        }
    }


    //Get by id
    public ResponseEntity<?> getAdminById(Long id) {
        logger.debug("--------->| Get Admin By ID |<---------");
        Admin admin;
        try {
            admin = adminRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Admin not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Admin Found Successfully |<---------");
        logger.debug("Admin (GET): {}", admin);
        return new ResponseEntity<>(admin, HttpStatus.FOUND);
    }

    //Update by id
    public ResponseEntity<String> updateAdmin(Long id, AdminDTO adminDTO) {
        logger.debug("---------> Update Admin By ID <---------");
        logger.debug("ID: {}, AdminDTO: {}", id, adminDTO);
        try {
            Admin admin = adminRepository.findById(id).get();
            logger.debug("Old Admin: {}", admin);
            admin.setAdminId(adminDTO.getAdminId());
            admin.setPassword(adminDTO.getPassword());
            try {
                logger.debug("Updated Admin (Save): {}", admin);
                adminRepository.save(admin);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Admin not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Admin Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteAdmin(Long id) {
        logger.debug("---------> Delete Admin By ID <---------");
        try {
            adminRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Admin not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Admin Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }

}
