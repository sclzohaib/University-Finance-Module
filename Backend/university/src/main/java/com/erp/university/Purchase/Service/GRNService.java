package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GRNDTO;
import com.erp.university.Purchase.Model.GRN;
import com.erp.university.Purchase.Repository.GRNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GRNService {
    @Autowired
    GRNRepository grnRepository;

    //Save GRN
    public ResponseEntity<String> saveGRN(GRNDTO grndto) {
        try {
            GRN grn = new GRN();
            grn.setDate(grndto.getDate());
            grn.setGrnNo(grndto.getGrnNo());
            grn.setPurchaseDate(grndto.getPurchaseDate());
            grn.setInspectedBy(grndto.getInspectedBy());
            grn.setPostedBy(grndto.getPostedBy());
            grn.setReasonForRejection(grndto.getReasonForRejection());
            grn.setRecievedQuantity(grndto.getRecievedQuantity());
            grn.setDepartmentHead(grndto.getDepartmentHead());
            grn.setTotalQuantity(grndto.getTotalQuantity());
            grn.setStatus(grndto.getStatus());
            grnRepository.save(grn);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //GET ALL GRN

    public ResponseEntity<?> getGRN() {
        List<GRN> grns;
        try {
            grns = grnRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(grns, HttpStatus.FOUND);
    }

    //GET Single GRN by ID

    public ResponseEntity<?> getGRNById(Long id) {
        GRN grn;
        try {
            grn = grnRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("GRN Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(grn, HttpStatus.FOUND);
    }

    //Update GRN By Id
    public ResponseEntity<String> updateGRN(Long id, GRNDTO grndto) {
        try {
            GRN grn = grnRepository.findById(id).get();
            grn.setDate(grndto.getDate());
            grn.setDepartmentHead(grndto.getDepartmentHead());
            grn.setGrnNo(grndto.getGrnNo());
            grn.setInspectedBy(grndto.getInspectedBy());
            grn.setPostedBy(grndto.getPostedBy());
            grn.setPurchaseDate(grndto.getPurchaseDate());
            grn.setReasonForRejection(grndto.getReasonForRejection());
            grn.setRecievedBy(grndto.getRecievedBy());
            grn.setRecievedQuantity(grndto.getRecievedQuantity());
            grn.setStatus(grndto.getStatus());
            grn.setTotalQuantity(grndto.getTotalQuantity());
            try {
                grnRepository.save(grn);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("GRN Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
