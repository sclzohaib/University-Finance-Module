package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Service.MinorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MinorHeadController {
    @Autowired
    MinorHeadService minorHeadService;
   @RequestMapping(value = "/",method = RequestMethod.POST)
public ResponseEntity<String> saveMinorHead(@RequestBody MinorHeadDTO minorHeadDTO)
   {
       return minorHeadService.saveMinorHead(minorHeadDTO);
   }
}
