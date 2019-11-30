package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Service.CoveringLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CoveringLetterController {
@Autowired
    CoveringLetterService coveringLetterService;
    @RequestMapping(value = "/n",method = RequestMethod.POST)
    public ResponseEntity<String> saveCoveringLetter (@RequestBody CoveringLetterDTO coveringLetterDTO)
    {
        return coveringLetterService.saveCoveringLetter(coveringLetterDTO);
    }
}
