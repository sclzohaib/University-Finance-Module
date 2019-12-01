package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Model.Vendor;
import com.erp.university.Purchase.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/api/vendor")
public class VendorController {
@Autowired
    VendorService vendorService;

//Post
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveVendor (@RequestBody VendorDTO vendorDTO)
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
    public ResponseEntity<Vendor> getById(Long id){
    return vendorService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(Long id, VendorDTO vendorDTO){
    return vendorService.update(id, vendorDTO);
    }

}
