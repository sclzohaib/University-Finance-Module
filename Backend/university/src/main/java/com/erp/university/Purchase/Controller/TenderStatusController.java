package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenderStatusDTO;
import com.erp.university.Purchase.Service.TenderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tenderStatus")
public class TenderStatusController {
    @Autowired
    TenderStatusService tenderStatusService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveTenderStatus(@Valid @RequestBody TenderStatusDTO tenderStatusDTO) {
        return tenderStatusService.saveTenderStatus(tenderStatusDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTenderStatus() {
        return tenderStatusService.getAllTenderStatus();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTenderStatusById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenderStatusService.getTenderStatusById(id);
    }


    //Update By id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTenderStatus(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody TenderStatusDTO tenderStatusDTO) {
        return tenderStatusService.updateTenderStatus(id, tenderStatusDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTenderStatus(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenderStatusService.deleteTenderStatus(id);
    }

}
