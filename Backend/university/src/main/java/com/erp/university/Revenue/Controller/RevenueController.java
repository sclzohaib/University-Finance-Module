package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.RevenueDTO;
import com.erp.university.Revenue.Services.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/revenue")
public class RevenueController {
    @Autowired
    RevenueService revenueService;
    //post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveRevenue(@Valid @RequestBody RevenueDTO revenueDTO)
    {
        return revenueService.saveRevenue(revenueDTO);
    }
}
