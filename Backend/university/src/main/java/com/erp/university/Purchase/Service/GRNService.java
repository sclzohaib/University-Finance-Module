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
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
}

        //GET ALL GRN

    public ResponseEntity<List<GRN>> getGRN(){
        List<GRN> grns = grnRepository.findAll();
        return new ResponseEntity<List<GRN>>(grns, HttpStatus.FOUND);
    }

    //GET Single GRN by ID

    public ResponseEntity<GRN> getGRNById(Long id){
        GRN grn = grnRepository.findById(id).get();
        return new ResponseEntity<GRN>(grn, HttpStatus.FOUND);
        }

        //Update GRN By Id
    public ResponseEntity<String> updateGRN(Long id, GRNDTO grndto){
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
        grnRepository.save(grn);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.OK);
    }


}
