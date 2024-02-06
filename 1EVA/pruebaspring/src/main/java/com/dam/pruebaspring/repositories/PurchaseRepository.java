package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>  { // Integer hace referencia al tipo de dato que es la clave primaria
    @Query("select p from Purchase p where p.name = ?1 OR p.id = ?1")
    List<Purchase> findByName(String name);
}
