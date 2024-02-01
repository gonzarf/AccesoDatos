package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>  { // Integer hace referencia al tipo de dato que es la clave primaria

}
