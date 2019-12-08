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
        MinorHead minorHead = new MinorHead();
        minorHead.setCodeNo(minorHeadDTO.getCodeNo());
        minorHead.setName(minorHeadDTO.getName());
        minorHeadRepository.save(minorHead);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<List<MinorHead>> getAllMinorHead() {
        List<MinorHead> minorHeads = minorHeadRepository.findAll();
        return new ResponseEntity<List<MinorHead>>(minorHeads, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<MinorHead> getMinorHeadById(Long id) {
        MinorHead minorHead = minorHeadRepository.findById(id).get();
        return new ResponseEntity<MinorHead>(minorHead, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateMinorHead(Long id, MinorHeadDTO minorHeadDTO) {
        MinorHead minorHead = minorHeadRepository.findById(id).get();
        minorHead.setCodeNo(minorHeadDTO.getCodeNo());
        minorHead.setName(minorHeadDTO.getName());
        minorHeadRepository.save(minorHead);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.FOUND);
    }
}
