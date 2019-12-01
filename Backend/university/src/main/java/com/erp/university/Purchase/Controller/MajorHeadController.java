package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Model.MajorHead;
import com.erp.university.Purchase.Service.MajorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  (value= "/api/majorHead")
public class MajorHeadController {
@Autowired
    MajorHeadService majorHeadService;
@RequestMapping(value = "/",method = RequestMethod.POST)

//Post
    public ResponseEntity<String> saveMajorHead (@RequestBody MajorHeadDTO majorHeadDTO)
{
    return majorHeadService.saveMajorHead(majorHeadDTO);
}

@RequestMapping(value = "/", method = RequestMethod.GET)
//Get all
    public ResponseEntity<List<MajorHead>> getAll(){
    return majorHeadService.getAll();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MajorHead> getById(@PathVariable("id") Long id){
    return majorHeadService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody MajorHeadDTO majorHeadDTO){
    return majorHeadService.update(id, majorHeadDTO);
    }
}
