package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Model.MajorHead;
import com.erp.university.Purchase.Repository.MajorHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MajorHeadService {
    @Autowired
    MajorHeadRepository majorHeadRepository;
    public ResponseEntity<String> saveMajorHead(MajorHeadDTO majorHeadDTO){
        MajorHead majorHead=new MajorHead();
        majorHead.setName(majorHeadDTO.getName());
        majorHeadRepository.save(majorHead);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);
    }
}
