package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenderStatusDTO;
import com.erp.university.Purchase.Service.TenderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/tenderStatus")
public class TenderStatusController {
    @Autowired
    TenderStatusService tenderStatusService;

    //Post
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveTenderStatus(@Valid @RequestBody TenderStatusDTO tenderStatusDTO)
    {
        return tenderStatusService.saveTenderStatus(tenderStatusDTO);
    }
}
