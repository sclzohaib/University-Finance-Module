package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.ClassDTO;
import com.erp.university.Revenue.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/revenue/class")
public class ClassController {
    @Autowired
    ClassService classService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveClass(@Valid @RequestBody ClassDTO classDTO) {
        return classService.saveClass(classDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllClass() {
        return classService.getAllClass();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClassById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return classService.getClassById(id);
    }

    //Update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClass(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody ClassDTO classDTO) {
        return classService.updateClass(id, classDTO);
    }

    //Delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClass(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return classService.deleteClass(id);
    }
}

