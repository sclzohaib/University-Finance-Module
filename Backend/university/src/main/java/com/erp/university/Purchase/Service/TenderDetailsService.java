package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenderDetailsDTO;
import com.erp.university.Purchase.Model.TenderDetails;
import com.erp.university.Purchase.Repository.TenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TenderDetailsService {
@Autowired
    TenderDetailsRepository tenderDetailsRepository;

public ResponseEntity<String> saveTenderDetails(TenderDetailsDTO tenderDetailsDTO)
{
    try{
        TenderDetails tenderDetails=new TenderDetails();
        tenderDetails.setDescription(tenderDetailsDTO.getDescription());
        tenderDetails.setDescriptionId(tenderDetailsDTO.getDescriptionId());
        tenderDetails.setQty(tenderDetailsDTO.getQty());
        tenderDetails.setTenderDetailId(tenderDetailsDTO.getTenderDetailId());
        tenderDetails.setTotalPrice(tenderDetailsDTO.getTotalPrice());
        tenderDetails.setUnitPrice(tenderDetailsDTO.getUnitPrice());
        tenderDetailsRepository.save(tenderDetails);
    }catch (Exception e)
    {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
}

}
