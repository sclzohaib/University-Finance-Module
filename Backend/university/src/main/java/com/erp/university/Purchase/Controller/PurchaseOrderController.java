package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/purchaseOrder")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    //Post Call
    @RequestMapping(value = " /", method = RequestMethod.POST)
    public ResponseEntity<String> savePurchaseOrder(@Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        return purchaseOrderService.savePurchaseOrder(purchaseOrderDTO);
    }

    //Get Call for All PO
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPurchaseOrder() {
        return purchaseOrderService.getAllPurchaseOrder();
    }

    //Get call for Single Purchase Order
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPurchaseOrderById(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return purchaseOrderService.getPurchaseOrderById(id);
    }


    //Put call to Update Purchase Order
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePurchaseOrder(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        return purchaseOrderService.updatePurchaseOrder(id, purchaseOrderDTO);
    }

    //delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePurchaseOrder(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return purchaseOrderService.deletePurchaseOrder(id);
    }
}
