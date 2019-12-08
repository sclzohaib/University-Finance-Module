package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Model.CoveringLetter;
import com.erp.university.Purchase.Repository.CoveringLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoveringLetterService {
    @Autowired
    CoveringLetterRepository coveringLetterRepository;

    //Save
    public ResponseEntity<String> saveCoveringLetter(CoveringLetterDTO coveringLetterDTO) {
        try {
            CoveringLetter coveringLetter = new CoveringLetter();
            coveringLetterRepository.save(coveringLetter);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getCoveringLetter() {
        List<CoveringLetter> coveringLetters;
        try {
            coveringLetters = coveringLetterRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coveringLetters, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getCoveringLetterById(Long id) {
        CoveringLetter coveringLetter = null;
        try {
            coveringLetter = coveringLetterRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Covering Letter Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coveringLetter, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateCoveringLetter(Long id, CoveringLetterDTO coveringLetterDTO) {
        try {
            CoveringLetter coveringLetter = coveringLetterRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Covering Letter Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}

