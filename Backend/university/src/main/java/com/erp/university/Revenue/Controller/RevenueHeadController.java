package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.RevenueHeadDTO;
import com.erp.university.Revenue.Services.RevenueHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping (value ="/api/revenueHead")
public class RevenueHeadController {
    @Autowired
    RevenueHeadService revenueHeadService;
    //Post
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveRevenueHead(@Valid @RequestBody RevenueHeadDTO revenueHeadDTO)
    {
        return revenueHeadService.saveRevenueHead(revenueHeadDTO);
    }
}
