package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Model.MinorHead;
import com.erp.university.Purchase.Repository.MinorHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MinorHeadService {
    @Autowired
    MinorHeadRepository minorHeadRepository;
    public ResponseEntity<String> saveMinorHead(MinorHeadDTO minorHeadDTO)
    {
        MinorHead minorHead=new MinorHead();
        minorHead.setCodeNo(minorHeadDTO.getCodeNo());
        minorHead.setName(minorHeadDTO.getName());
        minorHeadRepository.save(minorHead);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }
}
