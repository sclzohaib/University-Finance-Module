package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApplicationController {
@Autowired
    ApplicationService applicationService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveApplication(@RequestBody ApplicationDTO applicationDTO)
{
    return applicationService.saveApplication(applicationDTO);
}
}
