package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.UniversityDTO;
import com.erp.university.Purchase.Model.University;
import com.erp.university.Purchase.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveUniversity(@RequestBody UniversityDTO universityDTO){
        return universityService.saveUniversity(universityDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<University>> getUniversity(){
        return universityService.getUniversity();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getUniversityById(@PathVariable("id") Long id){
        return universityService.getUniversityById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUniveristy(@PathVariable("id") Long id, @RequestBody UniversityDTO universityDTO){

        return universityService.updateUniversity(id, universityDTO);
    }
}
