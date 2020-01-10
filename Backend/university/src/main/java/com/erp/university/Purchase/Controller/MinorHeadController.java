package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Service.MinorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/minorHead")
public class MinorHeadController {
    @Autowired
    MinorHeadService minorHeadService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveMinorHead(@Valid @RequestBody MinorHeadDTO minorHeadDTO) {
        return minorHeadService.saveMinorHead(minorHeadDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMinorHead() {
        return minorHeadService.getAllMinorHead();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMinorHeadById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return minorHeadService.getMinorHeadById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateMinorHead(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody MinorHeadDTO minorHeadDTO) {
        return minorHeadService.updateMinorHead(id, minorHeadDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMinorHead(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return minorHeadService.deleteMinorHead(id);
    }
}
