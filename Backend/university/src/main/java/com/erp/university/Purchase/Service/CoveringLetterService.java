package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Model.CoveringLetter;
import com.erp.university.Purchase.Repository.CoveringLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoveringLetterService {
    @Autowired
    CoveringLetterRepository coveringLetterRepository;
    public ResponseEntity<String> saveCoveringLetter(CoveringLetterDTO coveringLetterDTO)
    {
        CoveringLetter coveringLetter=new CoveringLetter();
        coveringLetterRepository.save(coveringLetter);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }
}
