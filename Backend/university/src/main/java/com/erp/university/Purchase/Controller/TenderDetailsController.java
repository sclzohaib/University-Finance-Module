package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenderDetailsDTO;
import com.erp.university.Purchase.Service.TenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/tenderDetails")
public class TenderDetailsController {
    @Autowired
    TenderDetailsService tenderDetailsService;

    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveTenderDetails(@Valid @RequestBody TenderDetailsDTO tenderDetailsDTO)
    {
        return tenderDetailsService.saveTenderDetails(tenderDetailsDTO);
    }
}