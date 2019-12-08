package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Model.GST;
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
    public ResponseEntity<String> saveGST(GSTDTO gstdto) {
        try {
            GST gst = new GST();
            gst.setPercent(gstdto.getPercent());
            gstRepository.save(gst);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getGst() {
        List<GST> gsts;
        try {
            gsts = gstRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gsts, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getGstById(Long id) {
        GST gst;
        try {
            gst = gstRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("GST Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gst, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateGst(Long id, GSTDTO gstdto) {
        try {
            GST gst = gstRepository.findById(id).get();
            gst.setPercent(gstdto.getPercent());
            try {
                gstRepository.save(gst);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("GST Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
