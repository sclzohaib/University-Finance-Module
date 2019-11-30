package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/summary")
public class SummaryController {
    @Autowired
    SummaryService summaryService;
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveSummary(@RequestBody SummaryDTO summaryDTO)
    {
        return summaryService.saveSummary(summaryDTO);
    }
}
