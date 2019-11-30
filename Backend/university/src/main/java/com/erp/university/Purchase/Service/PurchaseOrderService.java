package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Model.PurchaseOrder;
import com.erp.university.Purchase.Repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;
    public ResponseEntity<String> savePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
      purchaseOrder.setDate(purchaseOrderDTO.getDate());
      purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
      purchaseOrderRepository.save(purchaseOrder);
      return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }


}
