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
        try {
            MajorHead majorHead = new MajorHead();
            majorHead.setName(majorHeadDTO.getName());
            majorHeadRepository.save(majorHead);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllMajorHead() {
        List<MajorHead> majorHeads;
        try {
            majorHeads = majorHeadRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(majorHeads, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getMajorHeadById(Long id) {
        MajorHead majorHead;
        try {
            majorHead = majorHeadRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Major Head not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(majorHead, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateMajorHead(Long id, MajorHeadDTO majorHeadDTO) {
        try {
            MajorHead majorHead = majorHeadRepository.findById(id).get();
            majorHead.setName(majorHeadDTO.getName());
            try {
                majorHeadRepository.save(majorHead);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Major Head Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
