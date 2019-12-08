package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Model.Vendor;
import com.erp.university.Purchase.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    VendorRepository vendorRepository;

    //Save
    public ResponseEntity<String> saveVendor(VendorDTO vendorDTO) {
        Vendor vendor = new Vendor();
        vendor.settDate(vendorDTO.gettDate());
        vendor.setTel(vendorDTO.getTel());
        vendor.settLastDate(vendorDTO.gettLastDate());
        vendor.settQuotationAmount(vendorDTO.gettQuotationAmount());
        vendor.setvName(vendorDTO.getvName());
        vendorRepository.save(vendor);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<List<Vendor>> getAllVendor() {
        List<Vendor> vendors = vendorRepository.findAll();
        return new ResponseEntity<>(vendors, HttpStatus.FOUND);

    }

    //Get By id
    public ResponseEntity<Vendor> getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id).get();
        return new ResponseEntity<>(vendor, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorRepository.findById(id).get();
        vendor.settDate(vendorDTO.gettDate());
        vendor.setTel(vendorDTO.getTel());
        vendor.settLastDate(vendorDTO.gettLastDate());
        vendor.settQuotationAmount(vendorDTO.gettQuotationAmount());
        vendor.setvName(vendorDTO.getvName());
        vendorRepository.save(vendor);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
