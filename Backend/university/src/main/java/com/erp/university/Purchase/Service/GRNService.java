package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.GRNDTO;
import com.erp.university.Purchase.Model.GRN;
import com.erp.university.Purchase.Repository.GRNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GRNService {
    @Autowired
    GRNRepository grnRepository;

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


}
