package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Model.PurchaseOrder;
import com.erp.university.Purchase.Repository.PurchaseOrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {
    private static final Logger logger = LogManager.getLogger(PurchaseOrderService.class);
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    //Save Purchase Order
    public ResponseEntity<String> savePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        logger.debug("--------->| Create Purchase Order: |<---------");
        logger.debug("PurchaseOrderDTO: {}", purchaseOrderDTO);
        try {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setDate(purchaseOrderDTO.getDate());
            purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
            logger.debug("Purchase Order (POST): {}", purchaseOrder);
            purchaseOrderRepository.save(purchaseOrder);
            logger.debug("--------->| Purchase Order Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Succesfully\":1}", HttpStatus.CREATED);

    }

    //Get all Purchase order
    public ResponseEntity<?> getAllPurchaseOrder() {
        logger.debug("--------->| Get All Purchase Order |<---------");
        List<PurchaseOrder> purchaseOrders;
        try {
            purchaseOrders = purchaseOrderRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (purchaseOrders.isEmpty()) {
            logger.debug("No Purchase Order Record Found");
            return new ResponseEntity<>("{\"No Purchase Order Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Purchase Order Found Successfully |<---------");
            return new ResponseEntity<>(purchaseOrders, HttpStatus.FOUND);
        }
    }


    //Get Single Purchase Order
    public ResponseEntity<?> getPurchaseOrderById(Long id) {
        logger.debug("--------->| Get Purchase Order By ID |<---------");
        PurchaseOrder purchaseOrder;
        try {
            purchaseOrder = purchaseOrderRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Purchase Order Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Purchase Order Found Successfully |<---------");
        logger.debug("Purchase Order (GET): {}", purchaseOrder);
        return new ResponseEntity<>(purchaseOrder, HttpStatus.FOUND);
    }

    //Update Purchase Order
    public ResponseEntity<String> updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
        logger.debug("---------> Update Purchase Order By ID <---------");
        logger.debug("ID: {}, PurchaseOrderDTO: {}", id, purchaseOrderDTO);
        try {
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
            logger.debug("Old Purchase Order: {}", purchaseOrder);
            purchaseOrder.setDate(purchaseOrderDTO.getDate());
            purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
            try {
                logger.debug("Updated Purchase Order (Save): {}", purchaseOrder);
                purchaseOrderRepository.save(purchaseOrder);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Purchase Order Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Purchase Order Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deletePurchaseOrder(Long id) {
        logger.debug("---------> Delete Purchase Order By ID <---------");
        try {
            purchaseOrderRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Purchase Order not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Purchase Order Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }

}
