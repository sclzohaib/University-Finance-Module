package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Model.Tendor;
import com.erp.university.Purchase.Service.TendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tendor")
public class TendorController {
@Autowired
    TendorService tendorService;

//Post
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveTendor(@Valid @RequestBody TendorDTO tendorDTO)
{
    return tendorService.saveTendor(tendorDTO);
}

//Get all
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<Tendor>> getAll(){
    return tendorService.getAll();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tendor> getById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id){
    return tendorService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id")@Min(value = 1, message = "ID must be greater than 1") Long id,@Valid @RequestBody TendorDTO tendorDTO){
    return tendorService.update(id, tendorDTO);
    }
}
