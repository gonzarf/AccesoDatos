package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Purchase;
import com.dam.pruebaspring.servicies.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("all")
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("by-id/{id}")
    public Purchase getAllPurchasesById(@PathVariable Integer id){
        return purchaseService.getPurchasesById(id);
    }

    @PostMapping("save")
    public Purchase savePurchase(@RequestBody Purchase purchase){ return purchaseService.savePurchase(purchase);}

    @PutMapping("update")
    public Purchase upsatePurchase(@RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(purchase);
    }

    @DeleteMapping("delete/{id}")
    public Boolean deletePurchase(@PathVariable Integer id){ return purchaseService.deletePurchase(id);}
}
