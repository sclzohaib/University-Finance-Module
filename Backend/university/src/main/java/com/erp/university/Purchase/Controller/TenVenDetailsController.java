package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Service.TenVenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tenVenDetails")
public class TenVenDetailsController {
    @Autowired
    TenVenDetailService tenVenDetailService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveTenVenDetails(@Valid @RequestBody TenVenDTO tenVenDTO) {
        return tenVenDetailService.saveTenVenDetail(tenVenDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTenVenDetail() {
        return tenVenDetailService.getAllTenVenDetail();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTenVenDetailById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenVenDetailService.getTenVenDetailById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTenVenDetail(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody TenVenDTO tenVenDTO) {
        return tenVenDetailService.updateTenVenDetail(id, tenVenDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTenVenDetail(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return tenVenDetailService.deleteTenVenDetail(id);
    }
}
