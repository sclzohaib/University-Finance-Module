package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Model.MajorHead;
import com.erp.university.Purchase.Service.MajorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/majorHead")
public class MajorHeadController {
    @Autowired
    MajorHeadService majorHeadService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveMajorHead(@Valid @RequestBody MajorHeadDTO majorHeadDTO) {
        return majorHeadService.saveMajorHead(majorHeadDTO);
    }


    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MajorHead>> getAll() {
        return majorHeadService.getAll();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MajorHead> getById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return majorHeadService.getById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id,@Valid @RequestBody MajorHeadDTO majorHeadDTO) {
        return majorHeadService.update(id, majorHeadDTO);
    }
}
