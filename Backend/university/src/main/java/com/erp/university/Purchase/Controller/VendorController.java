package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/vendor")
public class VendorController {
    @Autowired
    VendorService vendorService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveVendor(@Valid @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendor(vendorDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllVendor() {
        return vendorService.getAllVendor();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getVendorById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return vendorService.getVendorById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateVendor(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody VendorDTO vendorDTO) {
        return vendorService.updateVendor(id, vendorDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteVendor(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return vendorService.deleteVendor(id);
    }
}
