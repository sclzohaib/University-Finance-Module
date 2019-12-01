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
    public ResponseEntity<String > saveTenVenDetail(TenVenDTO tenVenDTO)
    {
        TenVenDetails tenVenDetails=new TenVenDetails();
        tenVenDetails.setVendorAddress(tenVenDetails.getVendorAddress());
        tenVenDetails.setQuotation(tenVenDTO.getQuotation());
        tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
        tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
        tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
        tenVenRepository.save(tenVenDetails);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<List<TenVenDetails>> getAll(){
        List<TenVenDetails> tenVenDetails = tenVenRepository.findAll();
        return new ResponseEntity<List<TenVenDetails>>(tenVenDetails, HttpStatus.FOUND);
    }



    //Get by id
    public ResponseEntity<TenVenDetails> getById(Long id){
        TenVenDetails tenVenDetails = tenVenRepository.findById(id).get();
        return new ResponseEntity<TenVenDetails>(tenVenDetails,HttpStatus.FOUND);
    }

    //update
    public ResponseEntity<String> update(Long id, TenVenDTO tenVenDTO){
        TenVenDetails tenVenDetails = tenVenRepository.findById(id).get();
        tenVenDetails.setQuotation(tenVenDTO.getQuotation());
        tenVenDetails.setVendorAddress(tenVenDTO.getVendorAddress());
        tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
        tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
        tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
        tenVenRepository.save(tenVenDetails);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
