package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Model.GST;
import com.erp.university.Purchase.Service.GSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping (value= "/api/gst")
public class GSTController {
    @Autowired
    GSTService gstService;

    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveGST(@Valid @RequestBody GSTDTO gstdto)
    {
        return gstService.saveGST(gstdto);
    }

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<GST>> getGst(){
        return gstService.getGst();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GST> getGstById(@PathVariable("id") @Min(value = 1,message = "ID must be greater than 1") Long id){
        return gstService.getGsyById(id);
    }

    //Update
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGst(@PathVariable("id") @Min(value = 1,message = "ID must be greater than 1")  Long id, @RequestBody GSTDTO gstdto){
        return gstService.updateGst(id,gstdto);
    }
}
