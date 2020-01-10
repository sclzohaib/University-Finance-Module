package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.AdminDTO;
import com.erp.university.Revenue.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/revenue/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        return adminService.saveAdmin(adminDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return adminService.getAdminById(id);
    }

    //Update By id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAdmin(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

    //Delete By id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return adminService.deleteAdmin(id);
    }


}
