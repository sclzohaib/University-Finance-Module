package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Model.Tendor;
import com.erp.university.Purchase.Service.TendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tendor")
public class TendorController {
@Autowired
    TendorService tendorService;

//Post
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveTendor(@RequestBody TendorDTO tendorDTO)
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
    public ResponseEntity<Tendor> getById(@PathVariable("id") Long id){
    return tendorService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody TendorDTO tendorDTO){
    return tendorService.update(id, tendorDTO);
    }
}
