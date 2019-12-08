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
        CoveringLetter coveringLetter = new CoveringLetter();
        coveringLetterRepository.save(coveringLetter);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<List<CoveringLetter>> getCoveringLetter() {
        List<CoveringLetter> coveringLetters = coveringLetterRepository.findAll();
        return new ResponseEntity<>(coveringLetters, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<CoveringLetter> getCoveringLetterById(Long id) {
        CoveringLetter coveringLetter = coveringLetterRepository.findById(id).get();
        return new ResponseEntity<>(coveringLetter, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateCoveringLetter(Long id, CoveringLetterDTO coveringLetterDTO) {
        CoveringLetter coveringLetter = coveringLetterRepository.findById(id).get();
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}

