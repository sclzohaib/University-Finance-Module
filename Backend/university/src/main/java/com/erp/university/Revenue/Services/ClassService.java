package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.ClassDTO;
import com.erp.university.Revenue.Model.Class;
import com.erp.university.Revenue.Repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    //save
    public ResponseEntity<String> saveClass(ClassDTO classDTO)
    {
        try{
            Class stdclass =new Class();
            stdclass.setName(classDTO.getName());



        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
