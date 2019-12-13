package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.ClassDTO;
import com.erp.university.Revenue.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping (value = "/api/class")
public class ClassController {
    @Autowired
    ClassService classService;

    //Post
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveClass(@Valid @RequestBody ClassDTO classDTO)
    {
        return classService.saveClass(classDTO);
    }
}

