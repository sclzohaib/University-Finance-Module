package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.StudentTypeDTO;
import com.erp.university.Revenue.Services.StudentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/studentType")
public class StudentTypeController {
    @Autowired
    StudentTypeService studentTypeService;
    //post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveStudentType(@Valid @RequestBody StudentTypeDTO studentTypeDTO)
    {
        return studentTypeService.saveStudentType(studentTypeDTO);
    }
}
