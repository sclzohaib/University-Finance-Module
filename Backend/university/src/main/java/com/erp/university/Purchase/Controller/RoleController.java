package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.RoleDTO;
import com.erp.university.Purchase.Service.RoleService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //Post
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveRole(@Valid @RequestBody RoleDTO roleDTO)
    {
        return roleService.saveRole(roleDTO);
    }

}
