package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Model.Tendor;
import com.erp.university.Purchase.Repository.TendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TendorService {
    @Autowired
    TendorRepository tendorRepository;

    //Save
    public ResponseEntity<String> saveTendor(TendorDTO tendorDTO) {
        Tendor tendor = new Tendor();
        tendor.settNo(tendorDTO.gettNo());
        tendor.settStatus(tendor.gettStatus());
        tendorRepository.save(tendor);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<List<Tendor>> getAllTendor() {
        List<Tendor> tendors = tendorRepository.findAll();
        return new ResponseEntity<List<Tendor>>(tendors, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<Tendor> getTendorById(Long id) {
        Tendor tendor = tendorRepository.findById(id).get();
        return new ResponseEntity<Tendor>(tendor, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateTendor(Long id, TendorDTO tendorDTO) {
        Tendor tendor = tendorRepository.findById(id).get();
        tendor.settNo(tendorDTO.gettNo());
        tendor.settStatus(tendorDTO.gettStatus());
        tendorRepository.save(tendor);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}

