package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Model.PurchaseOrder;
import com.erp.university.Purchase.Repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    //Save Purchase Order
    public ResponseEntity<String> savePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setDate(purchaseOrderDTO.getDate());
        purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
        purchaseOrderRepository.save(purchaseOrder);
        return new ResponseEntity<String>("Added Succesfully", HttpStatus.CREATED);

    }

    //Get all Purchase order
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrder() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        return new ResponseEntity<List<PurchaseOrder>>(purchaseOrders, HttpStatus.FOUND);
    }


    //Get Single Purchase Order
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
        return new ResponseEntity<>(purchaseOrder, HttpStatus.FOUND);
    }

    //Update Purchase Order
    public ResponseEntity<String> updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
        purchaseOrder.setDate(purchaseOrderDTO.getDate());
        purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
        purchaseOrderRepository.save(purchaseOrder);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }

}
