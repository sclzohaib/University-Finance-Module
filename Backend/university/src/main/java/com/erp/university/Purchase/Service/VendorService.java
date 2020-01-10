package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.VendorDTO;
import com.erp.university.Purchase.Model.Vendor;
import com.erp.university.Purchase.Repository.VendorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);
    @Autowired
    VendorRepository vendorRepository;

    //Save
    public ResponseEntity<String> saveVendor(VendorDTO vendorDTO) {
        logger.debug("--------->| Create Vendor: |<---------");
        logger.debug("VendorDTO: {}", vendorDTO);
        try {
            Vendor vendor = new Vendor();
            vendor.settDate(vendorDTO.gettDate());
            vendor.setTel(vendorDTO.getTel());
            vendor.settLastDate(vendorDTO.gettLastDate());
            vendor.settQuotationAmount(vendorDTO.gettQuotationAmount());
            vendor.setvName(vendorDTO.getvName());
            logger.debug("Vendor (POST): {}", vendor);
            vendorRepository.save(vendor);
            logger.debug("--------->| Vendor Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get All
    public ResponseEntity<?> getAllVendor() {
        logger.debug("--------->| Get All Vendors |<---------");
        List<Vendor> vendors;
        try {
            vendors = vendorRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (vendors.isEmpty()) {
            logger.debug("No Vendor Record Found");
            return new ResponseEntity<>("{\"No Vendor Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Vendors Found Successfully |<---------");
            return new ResponseEntity<>(vendors, HttpStatus.FOUND);
        }

    }

    //Get By id
    public ResponseEntity<?> getVendorById(Long id) {
        logger.debug("--------->| Get Vendor By ID |<---------");
        Vendor vendor;
        try {
            vendor = vendorRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Vendor Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Vendor Found Successfully |<---------");
        logger.debug("Vendor (GET): {}", vendor);
        return new ResponseEntity<>(vendor, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateVendor(Long id, VendorDTO vendorDTO) {
        logger.debug("---------> Update Vendor By ID <---------");
        logger.debug("ID: {}, VendorDTO: {}", id, vendorDTO);
        try {
            Vendor vendor = vendorRepository.findById(id).get();
            logger.debug("Old Vendor: {}", vendor);
            vendor.settDate(vendorDTO.gettDate());
            vendor.setTel(vendorDTO.getTel());
            vendor.settLastDate(vendorDTO.gettLastDate());
            vendor.settQuotationAmount(vendorDTO.gettQuotationAmount());
            vendor.setvName(vendorDTO.getvName());
            try {
                logger.debug("Updated Vendor (Save): {}", vendor);
                vendorRepository.save(vendor);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Vendor Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Vendor Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }
    //delete by id
    public ResponseEntity<String> deleteVendor(Long id) {
        logger.debug("---------> Delete Vendor By ID <---------");
        try {
            vendorRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Vendor not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Vendor Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
