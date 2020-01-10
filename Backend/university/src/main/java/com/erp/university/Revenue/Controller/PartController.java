package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.PartDTO;
import com.erp.university.Revenue.Services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/revenue/part")
public class PartController {
    @Autowired
    PartService partService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> savePart(@Valid @RequestBody PartDTO partDTO) {
        return partService.savePart(partDTO);
    }

    //get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPart() {
        return partService.getAllPart();
    }

    //get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPartById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return partService.getPartById(id);
    }

    //update by id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePart(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody PartDTO partDTO) {
        return partService.updatePart(id, partDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePart(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return partService.deletePart(id);
    }

}
