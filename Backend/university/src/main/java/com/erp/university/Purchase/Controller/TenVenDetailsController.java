package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Service.TenVenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/tenVenDetails")
public class TenVenDetailsController {
@Autowired
    TenVenDetailService tenVenDetailService;
@RequestMapping(value = "/n", method = RequestMethod.POST)
    public ResponseEntity<String> saveTenVenDetails(@RequestBody TenVenDTO tenVenDTO)
{
    return tenVenDetailService.saveTenVenDetail(tenVenDTO);
}
}
