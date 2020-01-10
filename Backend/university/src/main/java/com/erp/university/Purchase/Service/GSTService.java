package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GSTDTO;
import com.erp.university.Purchase.Model.GST;
import com.erp.university.Purchase.Repository.GSTRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GSTService {
    private static final Logger logger = LogManager.getLogger(GSTService.class);
    @Autowired
    GSTRepository gstRepository;

    //Save
    public ResponseEntity<String> saveGST(GSTDTO gstdto) {
        logger.debug("--------->| Create GST: |<---------");
        logger.debug("GSTDTO: {}", gstdto);
        try {
            GST gst = new GST();
            gst.setPercent(gstdto.getPercent());
            logger.debug("GST (POST): {}", gst);
            gstRepository.save(gst);
            logger.debug("--------->| GST Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getGst() {
        logger.debug("--------->| Get All GST |<---------");
        List<GST> gsts;
        try {
            gsts = gstRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (gsts.isEmpty()) {
            logger.debug("No GST Record Found");
            return new ResponseEntity<>("{\"No GST Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Applications Found Successfully |<---------");
            return new ResponseEntity<>(gsts, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getGstById(Long id) {
        logger.debug("--------->| Get GST By ID |<---------");
        GST gst;
        try {
            gst = gstRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"GST Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| GST Found Successfully |<---------");
        logger.debug("GST (GET): {}", gst);
        return new ResponseEntity<>(gst, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateGst(Long id, GSTDTO gstdto) {
        logger.debug("---------> Update GST By ID <---------");
        logger.debug("ID: {}, GSTDTO: {}", id, gstdto);
        try {
            GST gst = gstRepository.findById(id).get();
            logger.debug("Old GST: {}", gst);
            gst.setPercent(gstdto.getPercent());
            try {
                logger.debug("Updated GST (Save): {}", gst);
                gstRepository.save(gst);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"GST Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| GST Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteGST(Long id) {
        logger.debug("---------> Delete GST By ID <---------");
        try {
            gstRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"GST not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| GST Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
