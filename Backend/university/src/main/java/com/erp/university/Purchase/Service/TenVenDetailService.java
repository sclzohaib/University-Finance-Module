package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Model.TenVenDetails;
import com.erp.university.Purchase.Repository.TenVenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TenVenDetailService {
    @Autowired
    TenVenRepository tenVenRepository;
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
}
