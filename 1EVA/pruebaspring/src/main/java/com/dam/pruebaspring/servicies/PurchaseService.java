package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Purchase;
import com.dam.pruebaspring.repositories.ProductRepository;
import com.dam.pruebaspring.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase getPurchasesById( Integer id){
        return purchaseRepository.findById(id).get();
    }

}
