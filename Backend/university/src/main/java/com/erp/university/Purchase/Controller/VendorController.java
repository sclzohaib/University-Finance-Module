package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Model.Vendor;
import com.erp.university.Purchase.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping (value = "/api/vendor")
public class VendorController {
@Autowired
    VendorService vendorService;

//Post
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveVendor (@Valid @RequestBody VendorDTO vendorDTO)
{
    return vendorService.saveVendor(vendorDTO);
}

//Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Vendor>> getAll(){
    return vendorService.getAll();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vendor> getById(@PathVariable("id") @Min(value=1 , message = "ID must be greater than 1") Long id){
    return vendorService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @RequestBody VendorDTO vendorDTO){
    return vendorService.update(id, vendorDTO);
    }

}
