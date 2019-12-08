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
        try {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setDate(purchaseOrderDTO.getDate());
            purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
            purchaseOrderRepository.save(purchaseOrder);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.CREATED);

    }

    //Get all Purchase order
    public ResponseEntity<?> getAllPurchaseOrder() {
        List<PurchaseOrder> purchaseOrders;
        try {
            purchaseOrders = purchaseOrderRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(purchaseOrders, HttpStatus.FOUND);
    }


    //Get Single Purchase Order
    public ResponseEntity<?> getPurchaseOrderById(Long id) {
        PurchaseOrder purchaseOrder;
        try {
            purchaseOrder = purchaseOrderRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Purchase Order Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(purchaseOrder, HttpStatus.FOUND);
    }

    //Update Purchase Order
    public ResponseEntity<String> updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
        try {
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
            purchaseOrder.setDate(purchaseOrderDTO.getDate());
            purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
            try {
                purchaseOrderRepository.save(purchaseOrder);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Purchase Order Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
