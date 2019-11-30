package com.erp.university.Purchase.Controller;

import com.erp.university.Purchase.DTO.PurchaseOrderDTO;
import com.erp.university.Purchase.Model.PurchaseOrder;
import com.erp.university.Purchase.Service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/purchaseOrder")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;
            @RequestMapping(value=" /",method = RequestMethod.POST)
    public ResponseEntity<String> savePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO)
            {
                return purchaseOrderService.savePurchaseOrder(purchaseOrderDTO);
            }
}
