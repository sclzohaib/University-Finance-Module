package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Model.MajorHead;
import com.erp.university.Purchase.Repository.MajorHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorHeadService {
    @Autowired
    MajorHeadRepository majorHeadRepository;

    //Save
    public ResponseEntity<String> saveMajorHead(MajorHeadDTO majorHeadDTO) {
        MajorHead majorHead = new MajorHead();
        majorHead.setName(majorHeadDTO.getName());
        majorHeadRepository.save(majorHead);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<List<MajorHead>> getAllMajorHead() {
        List<MajorHead> majorHeads = majorHeadRepository.findAll();
        return new ResponseEntity<List<MajorHead>>(majorHeads, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<MajorHead> getMajorHeadById(Long id) {
        MajorHead majorHead = majorHeadRepository.findById(id).get();
        return new ResponseEntity<MajorHead>(majorHead, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateMajorHead(Long id, MajorHeadDTO majorHeadDTO) {
        MajorHead majorHead = majorHeadRepository.findById(id).get();
        majorHead.setName(majorHeadDTO.getName());
        majorHeadRepository.save(majorHead);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}
