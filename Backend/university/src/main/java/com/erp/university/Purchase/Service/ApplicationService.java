package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Model.Application;
import com.erp.university.Purchase.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
@Autowired
    ApplicationRepository applicationRepository;
public ResponseEntity<String> saveApplication(ApplicationDTO applicationDTO)
{
    Application application = new Application();
    application.setAssociatePerson(applicationDTO.getAssociatePerson());
    application.setDate(applicationDTO.getDate());
    application.setStatus(applicationDTO.getStatus());
    application.setSubject(applicationDTO.getSubject());
    application.setStatus(applicationDTO.getStatus());
    applicationRepository.save(application);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

}
}

