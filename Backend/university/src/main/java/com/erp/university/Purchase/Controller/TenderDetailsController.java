package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenderDetailsDTO;
import com.erp.university.Purchase.Service.TenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tenderDetails")
public class TenderDetailsController {
    @Autowired
    TenderDetailsService tenderDetailsService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveTenderDetails(@Valid @RequestBody TenderDetailsDTO tenderDetailsDTO) {
        return tenderDetailsService.saveTenderDetails(tenderDetailsDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTenderDetails() {
        return tenderDetailsService.getAllTenderDetails();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTenderDetailsById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenderDetailsService.getTenderDetailsById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTenderDetails(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody TenderDetailsDTO tenderDetailsDTO) {
        return tenderDetailsService.updateTenderDetails(id, tenderDetailsDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTenderDetails(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenderDetailsService.deleteTenderDetails(id);
    }
}
