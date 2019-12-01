package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Model.Summary;
import com.erp.university.Purchase.Service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/summary")
public class SummaryController {
    @Autowired
    SummaryService summaryService;

    //Post
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveSummary(@RequestBody SummaryDTO summaryDTO)
    {
        return summaryService.saveSummary(summaryDTO);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Summary>> getAll(){
        return summaryService.getAll();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Summary> getById(@PathVariable("id") Long id){
        return summaryService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody SummaryDTO summaryDTO){
        return summaryService.update(id, summaryDTO);
    }
}
