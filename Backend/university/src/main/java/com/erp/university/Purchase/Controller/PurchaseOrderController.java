package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Model.PurchaseOrder;
import com.erp.university.Purchase.Service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/purchaseOrder")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    //Post Call
            @RequestMapping(value=" /",method = RequestMethod.POST)
    public ResponseEntity<String> savePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO)
            {
                return purchaseOrderService.savePurchaseOrder(purchaseOrderDTO);
            }

    //Get Call for All PO
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrder(){
                return purchaseOrderService.getPurchaseOrder();
    }

    //Get call for Single Purchase Order
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable("id") Long id){
                return purchaseOrderService.getPurchaseOrderById(id);
    }


    //Put call to Update Purchase Order
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePurchaseOrder(@PathVariable("id") Long id, @RequestBody PurchaseOrderDTO purchaseOrderDTO){
                return purchaseOrderService.updatePurchaseOrder(id, purchaseOrderDTO);
    }
}
