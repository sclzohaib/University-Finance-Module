package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Model.Application;
import com.erp.university.Purchase.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Application>> getApplication(){
    return applicationService.getApplication();
    }

    //Get by id
    public ResponseEntity<Application> getApplicationById(Long id){
    return applicationService.getApplicationById(id);
    }

    //Update Application
    public ResponseEntity<String> updateApplication(Long id, ApplicationDTO applicationDTO){
    return applicationService.updateApplication(id, applicationDTO);
    }
}
