package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.AdminDTO;
import com.erp.university.Revenue.Model.Admin;
import com.erp.university.Revenue.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    //Save
    public ResponseEntity<String> saveAdmin(AdminDTO adminDTO) {

        try {
            Admin admin = new Admin();
            admin.setAdminId(adminDTO.getAdminId());
            admin.setPassword(adminDTO.getPassword());
            adminRepository.save(admin);

        }catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    public ResponseEntity<?> getAllAdmin(){
        List<Admin> admins = adminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.FOUND);
    }

    public ResponseEntity<?> getAdminById(Long id){
        Admin admin = adminRepository.findById(id).get();
        return new ResponseEntity<>(admin, HttpStatus.FOUND);
    }

    public ResponseEntity<String> updateAdmin(Long id, AdminDTO adminDTO){
    Admin admin = adminRepository.findById(id).get();
    admin.setAdminId(adminDTO.getAdminId());
    admin.setPassword(adminDTO.getPassword());
    adminRepository.save(admin);
    return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteAdmin(Long id){
        adminRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
