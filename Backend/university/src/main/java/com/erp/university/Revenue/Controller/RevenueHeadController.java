package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.RevenueHeadDTO;
import com.erp.university.Revenue.Services.RevenueHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/revenue/revenueHead")
public class RevenueHeadController {
    @Autowired
    RevenueHeadService revenueHeadService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveRevenueHead(@Valid @RequestBody RevenueHeadDTO revenueHeadDTO) {
        return revenueHeadService.saveRevenueHead(revenueHeadDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRevenueHead() {
        return revenueHeadService.getAllRevenueHead();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRevenueHeadById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return revenueHeadService.getRevenueHeadById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRevenueHead(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody RevenueHeadDTO revenueHeadDTO) {
        return revenueHeadService.updateRevenueHead(id, revenueHeadDTO);
    }


    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRevenueHead(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return revenueHeadService.deleteRevenueHead(id);
    }


}
