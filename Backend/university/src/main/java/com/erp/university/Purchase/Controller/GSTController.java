package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Service.GSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/gst")
public class GSTController {
    @Autowired
    GSTService gstService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveGST(@Valid @RequestBody GSTDTO gstdto) {
        return gstService.saveGST(gstdto);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getGst() {
        return gstService.getGst();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getGstById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return gstService.getGstById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGst(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody GSTDTO gstdto) {
        return gstService.updateGst(id, gstdto);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteGst(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return gstService.deleteGST(id);
    }
}
