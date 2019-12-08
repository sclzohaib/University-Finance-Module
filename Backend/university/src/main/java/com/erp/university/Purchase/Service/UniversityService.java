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
        try {
            University university = new University();
            university.setName(universityDTO.getName());
            university.setLocation(universityDTO.getLocation());
            universityRepository.save(university);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllUniversity() {
        List<University> universityList;
        try {
            universityList = universityRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(universityList, HttpStatus.FOUND);
    }

    public ResponseEntity<?> getUniversityById(Long id) {
        University university;
        try {
            university = universityRepository.findById(id).get();

        } catch (Exception e) {

            return new ResponseEntity<>("University Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(university, HttpStatus.FOUND);

    }

    public ResponseEntity<String> updateUniversity(Long id, UniversityDTO universityDTO) {
        try {
            University university = universityRepository.findById(id).get();
            university.setName(universityDTO.getName());
            university.setLocation(universityDTO.getLocation());
            try {
                universityRepository.save(university);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("University Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
