package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Service.TendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TendorController {
@Autowired
    TendorService tendorService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveTendor(@RequestBody TendorDTO tendorDTO)
{
    return tendorService.saveTendor(tendorDTO);
}
}
