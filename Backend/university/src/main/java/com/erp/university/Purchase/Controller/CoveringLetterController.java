package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Service.CoveringLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/api/coveringLetter")
public class CoveringLetterController {
    @Autowired
    CoveringLetterService coveringLetterService;

    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveCoveringLetter(@Valid @RequestBody CoveringLetterDTO coveringLetterDTO) {
        return coveringLetterService.saveCoveringLetter(coveringLetterDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getCoveringLetter() {
        return coveringLetterService.getCoveringLetter();
    }

    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCoveringLetterById(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id) {
        return coveringLetterService.getCoveringLetterById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCoveringLetter(@PathVariable("id") @Min(value = 1, message = "Id must be greater than 1") Long id, @Valid @RequestBody CoveringLetterDTO coveringLetterDTO) {
        return coveringLetterService.updateCoveringLetter(id, coveringLetterDTO);
    }
}
