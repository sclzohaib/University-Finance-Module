package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Model.Vendor;
import com.erp.university.Purchase.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
@Autowired
    VendorRepository vendorRepository;
public ResponseEntity<String> saveVendor(VendorDTO vendorDTO)
{
    Vendor vendor=new Vendor();
    vendor.settDate(vendorDTO.gettDate());
    vendor.setTel(vendorDTO.getTel());
    vendor.settLastDate(vendorDTO.gettLastDate());
    vendor.settQuotationAmount(vendorDTO.gettQuotationAmount());
    vendor.setvName(vendorDTO.getvName());
    vendorRepository.save(vendor);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

}
}
