package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UniversityDTO;
import com.erp.university.Purchase.Model.University;
import com.erp.university.Purchase.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;

    public ResponseEntity<String> saveUniversity(UniversityDTO universityDTO) {
        University university = new University();
        university.setName(universityDTO.getName());
        university.setLocation(universityDTO.getLocation());
        universityRepository.save(university);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<University>> getAllUniversity() {
        List<University> universityList = universityRepository.findAll();
        return new ResponseEntity<>(universityList, HttpStatus.FOUND);
    }

    public Object getUniversityById(Long id) {
        University university;
        try {
            university = universityRepository.findById(id).get();

        } catch (Exception e) {

            return new ResponseEntity<>("No University Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(university, HttpStatus.FOUND);

    }

    public ResponseEntity<String> updateUniversity(Long id, UniversityDTO universityDTO) {

        University university = universityRepository.findById(id).get();
        university.setName(universityDTO.getName());
        university.setLocation(universityDTO.getLocation());
        universityRepository.save(university);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
