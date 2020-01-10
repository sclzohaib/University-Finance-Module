package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.StudentTypeDTO;
import com.erp.university.Revenue.Services.StudentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/revenue/studentType")
public class StudentTypeController {
    @Autowired
    StudentTypeService studentTypeService;


    //post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveStudentType(@Valid @RequestBody StudentTypeDTO studentTypeDTO) {
        return studentTypeService.saveStudentType(studentTypeDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllStudentType() {
        return studentTypeService.getAllStudentType();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentTypeById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return studentTypeService.getStudentTypeById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudentType(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody StudentTypeDTO studentTypeDTO) {
        return studentTypeService.updateStudentType(id, studentTypeDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentTypeById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return studentTypeService.deleteStudentTypeById(id);
    }

}

