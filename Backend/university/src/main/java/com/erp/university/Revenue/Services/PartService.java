package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.PartDTO;
import com.erp.university.Revenue.Model.Part;
import com.erp.university.Revenue.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PartService {
    @Autowired
    PartRepository partRepository;
    public ResponseEntity<String> savePart(PartDTO partDTO)
    {
        try{
            Part part=new Part();
            part.setName(partDTO.getName());
            partRepository.save(part);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
