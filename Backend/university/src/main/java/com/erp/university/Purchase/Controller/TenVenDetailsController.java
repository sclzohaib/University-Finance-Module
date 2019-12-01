package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Model.TenVenDetails;
import com.erp.university.Purchase.Service.TenVenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/tenVenDetails")
public class TenVenDetailsController {
@Autowired
    TenVenDetailService tenVenDetailService;

//Post
@RequestMapping(value = "/n", method = RequestMethod.POST)
    public ResponseEntity<String> saveTenVenDetails(@RequestBody TenVenDTO tenVenDTO)
{
    return tenVenDetailService.saveTenVenDetail(tenVenDTO);
}

//Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TenVenDetails>> getAll(){
    return tenVenDetailService.getAll();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TenVenDetails> getById(@PathVariable("id") Long id){
    return tenVenDetailService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody TenVenDTO tenVenDTO){
    return tenVenDetailService.update(id, tenVenDTO);
    }
}
