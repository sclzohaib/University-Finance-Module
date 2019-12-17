package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PermissionDTO;
import com.erp.university.Purchase.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> savePermission(@Valid @RequestBody PermissionDTO permissionDTO)
    {
        return permissionService.savePermission(permissionDTO);
    }
}
