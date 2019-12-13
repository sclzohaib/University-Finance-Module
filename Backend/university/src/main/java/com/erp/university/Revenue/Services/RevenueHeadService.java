package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.RevenueHeadDTO;
import com.erp.university.Revenue.Model.RevenueHead;
import com.erp.university.Revenue.Repository.RevenueHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RevenueHeadService {
    @Autowired
    RevenueHeadRepository revenueHeadRepository;
    //save
    public ResponseEntity<String> saveRevenueHead(RevenueHeadDTO revenueHeadDTO)
    {
        try{
            RevenueHead revenueHead=new RevenueHead();
            revenueHead.setName(revenueHeadDTO.getName());
            revenueHead.setCode(revenueHeadDTO.getCode());
            revenueHeadRepository.save(revenueHead);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }
}
