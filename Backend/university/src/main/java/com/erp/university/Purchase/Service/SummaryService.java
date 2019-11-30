package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Model.Summary;
import com.erp.university.Purchase.Repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {
    @Autowired
    SummaryRepository summaryRepository;
    public ResponseEntity<String> saveSummary (SummaryDTO summaryDTO)
    {
        Summary summary=new Summary();
        summaryRepository.save(summary);
        return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }
}
