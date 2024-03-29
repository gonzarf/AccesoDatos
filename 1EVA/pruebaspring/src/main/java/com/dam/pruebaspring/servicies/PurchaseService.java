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

    public Purchase savePurchase(Purchase purchase){ return purchaseRepository.save(purchase);}

    public Purchase updatePurchase(Purchase purchase){ return purchaseRepository.save(purchase);}

    public Boolean deletePurchase(Integer id){
        purchaseRepository.deleteById(id);
        return !purchaseRepository.findById(id).isPresent();
    }

    public List<Purchase> getPurchasesByName(String busqueda) {
        return purchaseRepository.findByName(String name);
    }
}
