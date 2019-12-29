package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.RoleDTO;
import com.erp.university.Purchase.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveRole(@Valid @RequestBody RoleDTO roleDTO) {
        return roleService.saveRole(roleDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRole() {
        return roleService.getAllRole();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRoleById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return roleService.getRoleById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRole(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(id, roleDTO);
    }

}
