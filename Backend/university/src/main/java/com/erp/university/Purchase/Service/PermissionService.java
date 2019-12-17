package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PermissionDTO;
import com.erp.university.Purchase.Model.Permission;
import com.erp.university.Purchase.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;
    public ResponseEntity<String> savePermission(PermissionDTO permissionDTO)
    {

        try{
            Permission permission =new Permission();
            permission.setId(permissionDTO.getId());
            permission.setConstName(permissionDTO.getConstName());
            permission.setTitle(permissionDTO.getTitle());
            permissionRepository.save(permission);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
