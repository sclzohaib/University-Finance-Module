package com.erp.university.Revenue.Controller;

import com.erp.university.Purchase.Service.VendorService;
import com.erp.university.Revenue.DTO.AdminDTO;
import com.erp.university.Revenue.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //Post
    @RequestMapping (value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveAdmin(@Valid @RequestBody AdminDTO adminDTO)
    {
        return adminService.saveAdmin(adminDTO);
    }




}
