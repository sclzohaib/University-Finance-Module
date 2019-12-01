package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Model.GST;
import com.erp.university.Purchase.Repository.GRNRepository;
import com.erp.university.Purchase.Repository.GSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GSTService {
    @Autowired
    GSTRepository gstRepository;

    //Save
    public ResponseEntity<String> saveGST(GSTDTO gstdto){
        GST gst =new GST();
        gst.setPercent(gstdto.getPercent());
        gstRepository.save(gst);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<List<GST>> getGst(){
        List<GST> gsts = gstRepository.findAll();
        return new ResponseEntity<List<GST>>(gsts, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<GST> getGsyById(Long id){
        GST gst = gstRepository.findById(id).get();
        return new ResponseEntity<GST>(gst,HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateGst(Long id, GSTDTO gstdto){
        GST gst = gstRepository.findById(id).get();
        gst.setPercent(gstdto.getPercent());
        gstRepository.save(gst);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
