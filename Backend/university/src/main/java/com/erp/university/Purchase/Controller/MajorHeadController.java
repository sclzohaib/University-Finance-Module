package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Service.MajorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MajorHeadController {
@Autowired
    MajorHeadService majorHeadService;
@RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveMajorHead (@RequestBody MajorHeadDTO majorHeadDTO)
{
    return majorHeadService.saveMajorHead(majorHeadDTO);
}
}
