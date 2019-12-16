package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenderStatusDTO;
import com.erp.university.Purchase.Model.TenderStatus;
import com.erp.university.Purchase.Repository.TenderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TenderStatusService {
@Autowired
    TenderStatusRepository tenderStatusRepository;
public ResponseEntity<String> saveTenderStatus(TenderStatusDTO tenderStatusDTO)
{
    try{
        TenderStatus tenderStatus=new TenderStatus();
        tenderStatus.setId(tenderStatusDTO.getId());
        tenderStatus.setName(tenderStatusDTO.getName());
        tenderStatusRepository.save(tenderStatus);
    }catch (Exception e)
    {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
}


}
