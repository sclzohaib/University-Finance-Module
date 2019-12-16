package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.RevenueDTO;
import com.erp.university.Revenue.Services.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/revenue/revenue")
public class RevenueController {
    @Autowired
    RevenueService revenueService;

    //post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveRevenue(@Valid @RequestBody RevenueDTO revenueDTO) {
        return revenueService.saveRevenue(revenueDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRevenue() {
        return revenueService.getAllRevenue();
    }

    // get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRevenueById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return revenueService.getRevenueById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRevenue(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody RevenueDTO revenueDTO) {
        return revenueService.updateRevenue(id, revenueDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRevenue(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return revenueService.deleteRevenue(id);

    }

}
