package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Model.GST;
import com.erp.university.Purchase.Repository.GRNRepository;
import com.erp.university.Purchase.Repository.GSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GSTService {
    @Autowired
    GSTRepository gstRepository;
    public ResponseEntity<String> saveGST(GSTDTO gstdto){
        GST gst =new GST();
        gst.setPercent(gstdto.getPercent());
        gstRepository.save(gst);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }
}
