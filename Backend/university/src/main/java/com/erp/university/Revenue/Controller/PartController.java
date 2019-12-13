package com.erp.university.Revenue.Controller;

import com.erp.university.Revenue.DTO.PartDTO;
import com.erp.university.Revenue.Services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/part")
public class PartController {
    @Autowired
    PartService partService;
    //Post
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> savePart(@Valid @RequestBody PartDTO partDTO)
    {
        return partService.savePart(partDTO);
    }

}
