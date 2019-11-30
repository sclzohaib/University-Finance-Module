package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.GRNDTO;
import com.erp.university.Purchase.Service.GRNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/grn")
public class GRNController {
    @Autowired
    GRNService grnService;
            @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public ResponseEntity<String> saveGRN(@RequestBody GRNDTO grndto)
            {
                return grnService.saveGRN(grndto);
            }

}
