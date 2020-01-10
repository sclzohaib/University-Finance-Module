package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PermissionDTO;
import com.erp.university.Purchase.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> savePermission(@Valid @RequestBody PermissionDTO permissionDTO) {
        return permissionService.savePermission(permissionDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermission() {
        return permissionService.getAllPermission();
    }

    //Get by Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPermissionById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return permissionService.getPermissionById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePermission(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody PermissionDTO permissionDTO) {
        return permissionService.updatePermission(id, permissionDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePermission(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return permissionService.deletePermission(id);
    }
}
