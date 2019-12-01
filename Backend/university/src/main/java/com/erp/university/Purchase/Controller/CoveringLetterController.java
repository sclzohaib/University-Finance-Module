package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Model.CoveringLetter;
import com.erp.university.Purchase.Service.CoveringLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value ="/api/coveringLetter")
public class CoveringLetterController {
@Autowired
    CoveringLetterService coveringLetterService;

//Post
    @RequestMapping(value = "/n",method = RequestMethod.POST)
    public ResponseEntity<String> saveCoveringLetter (@RequestBody CoveringLetterDTO coveringLetterDTO)
    {
        return coveringLetterService.saveCoveringLetter(coveringLetterDTO);
    }

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CoveringLetter>> getCoveringLetter(){
        return coveringLetterService.getCoveringLetter();
    }
    //Get By id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CoveringLetter> getCoveringLetterById(Long id){
        return coveringLetterService.getCoveringLetterById(id);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCoveringLetter(Long id, CoveringLetterDTO coveringLetterDTO){
        return coveringLetterService.updateCoveringLetter(id, coveringLetterDTO);
    }
}
