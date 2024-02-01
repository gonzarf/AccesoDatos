package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Purchase;
import com.dam.pruebaspring.servicies.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
