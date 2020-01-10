package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UniversityDTO;
import com.erp.university.Purchase.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveUniversity(@Valid @RequestBody UniversityDTO universityDTO) {
        return universityService.saveUniversity(universityDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUniversity() {
        return universityService.getAllUniversity();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUniversityById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return universityService.getUniversityById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUniversity(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody UniversityDTO universityDTO) {

        return universityService.updateUniversity(id, universityDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUniversity(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return universityService.deleteUniversity(id);
    }
}
