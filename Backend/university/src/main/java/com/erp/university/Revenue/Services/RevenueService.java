package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.RevenueDTO;
import com.erp.university.Revenue.Model.Revenue;
import com.erp.university.Revenue.Repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {
    @Autowired
    RevenueRepository revenueRepository;
    public ResponseEntity<String> saveRevenue(RevenueDTO revenueDTO)
    {
        try
        {
            Revenue revenue=new Revenue();
            revenue.setAmount(revenueDTO.getAmount());
            revenue.setDescription(revenueDTO.getDescription());
            revenue.setPaid(revenueDTO.getPaid());
            revenue.setPart(revenueDTO.getPart());
            revenue.setRevenueHead(revenueDTO.getRevenueHead());
            revenue.setStdClass(revenueDTO.getStdClass());
            revenue.setStudentType(revenueDTO.getStudentType());
            revenue.setWithForm(revenueDTO.getWithForm());
            revenueRepository.save(revenue);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added successfully",HttpStatus.CREATED);
    }
}
