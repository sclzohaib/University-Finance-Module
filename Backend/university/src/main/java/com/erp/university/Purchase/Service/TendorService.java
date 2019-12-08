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
        try {
            Tendor tendor = new Tendor();
            tendor.settNo(tendorDTO.gettNo());
            tendor.settStatus(tendor.gettStatus());
            tendorRepository.save(tendor);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllTendor() {
        List<Tendor> tendors;
        try {
            tendors = tendorRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tendors, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getTendorById(Long id) {
        Tendor tendor;
        try {
            tendor = tendorRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Tendor Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tendor, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateTendor(Long id, TendorDTO tendorDTO) {
        try {
            Tendor tendor = tendorRepository.findById(id).get();
            tendor.settNo(tendorDTO.gettNo());
            tendor.settStatus(tendorDTO.gettStatus());
            try {
                tendorRepository.save(tendor);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Tendor not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}

