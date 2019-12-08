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
        try {
            Summary summary = new Summary();
            summaryRepository.save(summary);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllSummary() {
        List<Summary> summaries;
        try {
            summaries = summaryRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(summaries, HttpStatus.FOUND);
    }

    //Get by id
    public ResponseEntity<?> getSummaryById(Long id) {
        Summary summary;
        try {
            summary = summaryRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Summary Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(summary, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateSummary(Long id, SummaryDTO summaryDTO) {
        try {
            Summary summary = summaryRepository.findById(id).get();
            try {
                summaryRepository.save(summary);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Summary Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
