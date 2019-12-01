package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VendorController {
@Autowired
    VendorService vendorService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveVendor (@RequestBody VendorDTO vendorDTO)
{
    return vendorService.saveVendor(vendorDTO);
}

}
