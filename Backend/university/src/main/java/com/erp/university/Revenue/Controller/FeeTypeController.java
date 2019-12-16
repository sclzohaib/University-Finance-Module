package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.FeeTypeDTO;
import com.erp.university.Revenue.Services.FeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/revenue/feeType")
public class FeeTypeController {
    @Autowired
    FeeTypeService feeTypeService;

    //post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveFeeType(@Valid @RequestBody FeeTypeDTO feeTypeDTO) {
        return feeTypeService.saveFeeType(feeTypeDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllFeeType() {
        return feeTypeService.getAllFeeType();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFeeTypeById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return feeTypeService.getFeeTypeById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateFeeType(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody FeeTypeDTO feeTypeDTO) {
        return feeTypeService.updateFeeType(id, feeTypeDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFeeType(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return feeTypeService.deleteFeeType(id);
    }
}
