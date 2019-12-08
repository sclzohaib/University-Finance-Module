package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.GRNDTO;
import com.erp.university.Purchase.Service.GRNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/grn")
public class GRNController {
    @Autowired
    GRNService grnService;

    //Save GRN (POST Call)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveGRN(@Valid @RequestBody GRNDTO grndto) {
        return grnService.saveGRN(grndto);
    }


    //GET GRN (GET CALL)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getGRN() {
        return grnService.getGRN();
    }


    //Get GRN By ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getGRNById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return grnService.getGRNById(id);
    }

    //Update GRN By ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGRN(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody GRNDTO grndto) {
        return grnService.updateGRN(id, grndto);
    }

}
