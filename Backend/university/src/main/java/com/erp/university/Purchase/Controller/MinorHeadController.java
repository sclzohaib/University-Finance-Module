package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Model.MinorHead;
import com.erp.university.Purchase.Service.MinorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  (value= "/api/minorHead")
public class MinorHeadController {
    @Autowired
    MinorHeadService minorHeadService;

    //Post
   @RequestMapping(value = "/",method = RequestMethod.POST)
public ResponseEntity<String> saveMinorHead(@RequestBody MinorHeadDTO minorHeadDTO)
   {
       return minorHeadService.saveMinorHead(minorHeadDTO);
   }

   //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MinorHead>> getAll(){
       return minorHeadService.getAll();
    }

    //Get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MinorHead> getById(@PathVariable("id") Long id){
       return minorHeadService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody MinorHeadDTO minorHeadDTO){
       return minorHeadService.update(id, minorHeadDTO);
    }
}
