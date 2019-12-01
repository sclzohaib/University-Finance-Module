package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Service.GSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value= "/api/gst")
public class GSTController {
    @Autowired
    GSTService gstService;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<String> saveGST(@RequestBody GSTDTO gstdto)
    {
        return gstService.saveGST(gstdto);
    }
}
