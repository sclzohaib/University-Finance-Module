package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.StudentTypeDTO;
import com.erp.university.Revenue.Model.StudentType;
import com.erp.university.Revenue.Repository.StudentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class StudentTypeService {
    @Autowired
    StudentTypeRepository studentTypeRepository;
    public ResponseEntity<String> saveStudentType(StudentTypeDTO studentTypeDTO)
    {
        try
        {
            StudentType studentType=new StudentType();
            studentType.setName(studentTypeDTO.getName());
            studentTypeRepository.save(studentType);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
