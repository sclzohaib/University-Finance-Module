package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Model.MinorHead;
import com.erp.university.Purchase.Repository.MinorHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinorHeadService {
    @Autowired
    MinorHeadRepository minorHeadRepository;

    //Save
    public ResponseEntity<String> saveMinorHead(MinorHeadDTO minorHeadDTO) {
        try {
            MinorHead minorHead = new MinorHead();
            minorHead.setCodeNo(minorHeadDTO.getCodeNo());
            minorHead.setName(minorHeadDTO.getName());
            minorHeadRepository.save(minorHead);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<?> getAllMinorHead() {
        List<MinorHead> minorHeads;
        try {
            minorHeads = minorHeadRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(minorHeads, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getMinorHeadById(Long id) {
        MinorHead minorHead;
        try {
            minorHead = minorHeadRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Minor Head Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(minorHead, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateMinorHead(Long id, MinorHeadDTO minorHeadDTO) {
        try {
            MinorHead minorHead = minorHeadRepository.findById(id).get();
            minorHead.setCodeNo(minorHeadDTO.getCodeNo());
            minorHead.setName(minorHeadDTO.getName());
            try {
                minorHeadRepository.save(minorHead);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Minor Head Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.FOUND);
    }
}
