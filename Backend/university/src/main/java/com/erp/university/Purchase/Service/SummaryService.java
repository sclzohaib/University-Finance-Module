package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Model.Summary;
import com.erp.university.Purchase.Repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {
    @Autowired
    SummaryRepository summaryRepository;

    //Save
    public ResponseEntity<String> saveSummary(SummaryDTO summaryDTO) {
        Summary summary = new Summary();
        summaryRepository.save(summary);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<List<Summary>> getAllSummary() {
        List<Summary> summaries = summaryRepository.findAll();
        return new ResponseEntity<>(summaries, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<Summary> getSummaryById(Long id) {
        Summary summary = summaryRepository.findById(id).get();
        return new ResponseEntity<>(summary, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateSummary(Long id, SummaryDTO summaryDTO) {
        Summary summary = summaryRepository.findById(id).get();
        summaryRepository.save(summary);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
