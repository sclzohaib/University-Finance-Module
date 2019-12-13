package com.erp.university.Revenue.Services;

import com.erp.university.Revenue.DTO.FeeTypeDTO;
import com.erp.university.Revenue.Model.FeeType;
import com.erp.university.Revenue.Repository.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeeTypeService {
    @Autowired
    FeeTypeRepository feeTypeRepository;
    //save
    public ResponseEntity<String> saveFeeType(FeeTypeDTO feeTypeDTO)
    {
        try{
            FeeType feeType=new FeeType();
            feeType.setAmount(feeTypeDTO.getAmount());
            feeType.setClasses(feeTypeDTO.getClasses());
            feeType.setDescription(feeTypeDTO.getDescription());
            feeType.setParts(feeTypeDTO.getParts());
            feeType.setRevenueHead(feeTypeDTO.getRevenueHead());
            feeType.setStudentTypes(feeTypeDTO.getStudentTypes());
            feeTypeRepository.save(feeType);

        }catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added successfully",HttpStatus.CREATED );
    }
}
