package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UniversityDTO;
import com.erp.university.Purchase.Model.University;
import com.erp.university.Purchase.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveUniversity(@Valid @RequestBody UniversityDTO universityDTO){
        return universityService.saveUniversity(universityDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<University>> getUniversity(){
        return universityService.getUniversity();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getUniversityById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return universityService.getUniversityById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUniveristy(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody UniversityDTO universityDTO){

        return universityService.updateUniversity(id, universityDTO);
    }
}
