package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.RoleDTO;
import com.erp.university.Purchase.Model.Role;
import com.erp.university.Purchase.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public ResponseEntity<String> saveRole(RoleDTO roleDTO)
    {
        try {
            Role role=new Role();
            role.setId(roleDTO.getId());
            role.setTitle(roleDTO.getTitle());
            roleRepository.save(role);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
