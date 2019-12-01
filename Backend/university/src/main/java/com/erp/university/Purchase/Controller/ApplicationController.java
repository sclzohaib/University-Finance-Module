package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Model.Application;
import com.erp.university.Purchase.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  (value="/api/application")
public class ApplicationController {
@Autowired
    ApplicationService applicationService;

    //Post Call
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveApplication(@RequestBody ApplicationDTO applicationDTO)
{
    return applicationService.saveApplication(applicationDTO);
}

    //Get all call
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getApplication(){
    return applicationService.getApplication();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id){
    return applicationService.getApplicationById(id);
    }

    //Update Application
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateApplication(@PathVariable("id") Long id,@RequestBody ApplicationDTO applicationDTO){
    return applicationService.updateApplication(id, applicationDTO);
    }
}
