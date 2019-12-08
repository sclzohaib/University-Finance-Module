package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Model.TenVenDetails;
import com.erp.university.Purchase.Repository.TenVenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenVenDetailService {
    @Autowired
    TenVenRepository tenVenRepository;

    //Save
    public ResponseEntity<String> saveTenVenDetail(TenVenDTO tenVenDTO) {
        try {
            TenVenDetails tenVenDetails = new TenVenDetails();
            tenVenDetails.setVendorAddress(tenVenDetails.getVendorAddress());
            tenVenDetails.setQuotation(tenVenDTO.getQuotation());
            tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
            tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
            tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
            tenVenRepository.save(tenVenDetails);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<?> getAllTenVenDetail() {
        List<TenVenDetails> tenVenDetails;
        try {
            tenVenDetails = tenVenRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tenVenDetails, HttpStatus.FOUND);
    }


    //Get by id
    public ResponseEntity<?> getTenVenDetailById(Long id) {
        TenVenDetails tenVenDetails;
        try {
            tenVenDetails = tenVenRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Tendor Vendor Details not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tenVenDetails, HttpStatus.FOUND);
    }

    //update
    public ResponseEntity<String> updateTenVenDetail(Long id, TenVenDTO tenVenDTO) {
        try {
            TenVenDetails tenVenDetails = tenVenRepository.findById(id).get();
            tenVenDetails.setQuotation(tenVenDTO.getQuotation());
            tenVenDetails.setVendorAddress(tenVenDTO.getVendorAddress());
            tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
            tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
            tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
            try {
                tenVenRepository.save(tenVenDetails);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Tendor Vendor Details not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
