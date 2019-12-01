package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Model.Tendor;
import com.erp.university.Purchase.Repository.TendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TendorService {
@Autowired
    TendorRepository tendorRepository;
public ResponseEntity<String> saveTendor(TendorDTO tendorDTO)
{
    Tendor tendor =new Tendor();
    tendor.settNo(tendorDTO.gettNo());
    tendor.settStatus(tendor.gettStatus());
    tendorRepository.save(tendor);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
}
}

