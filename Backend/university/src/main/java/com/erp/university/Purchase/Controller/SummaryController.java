package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/summary")
public class SummaryController {
    @Autowired
    SummaryService summaryService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveSummary(@Valid @RequestBody SummaryDTO summaryDTO) {
        return summaryService.saveSummary(summaryDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSummary() {
        return summaryService.getAllSummary();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSummaryById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return summaryService.getSummaryById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSummary(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody SummaryDTO summaryDTO) {
        return summaryService.updateSummary(id, summaryDTO);
    }
}
