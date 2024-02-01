package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Product;
import com.dam.pruebaspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductByPrice(BigDecimal price){
        return productRepository.findAll();
    }

    public List<Product> getProductByString(String string){
        return productRepository.findAll();
    }

    public Boolean deleteProduct(Integer id){
        productRepository.deleteById(id);

        return !productRepository.findById(id).isPresent();

    }
}
