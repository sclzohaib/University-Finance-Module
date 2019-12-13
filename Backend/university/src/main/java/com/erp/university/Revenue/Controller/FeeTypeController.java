package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.FeeTypeDTO;
import com.erp.university.Revenue.Services.FeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/feeType")
public class FeeTypeController {
    @Autowired
    FeeTypeService feeTypeService;
    //post
    @RequestMapping( value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveFeeType(@Valid @RequestBody FeeTypeDTO feeTypeDTO)
    {
        return feeTypeService.saveFeeType(feeTypeDTO);
    }
}
