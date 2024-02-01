package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Product;
import com.dam.pruebaspring.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/save") // Si el id no esta hace un insert y si lo escribimos, hace un update
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/names")
    public List<String> getAllProductNames() {
        List<Product> allProducts = productService.getAllProducts();
        ArrayList<String> allNames = new ArrayList<String>();

        for (Product product : allProducts){
            allNames.add(product.getName());
        }

        return allNames;
    }

    @GetMapping("/under-price/{price}")
    public List<Product> getProductsByPrice(@PathVariable BigDecimal price){
        List<Product> allProducts = productService.getAllProducts();
        List<Product> byPrice = new ArrayList<Product>();

        for (Product product : allProducts){
            if (product.getPrice().compareTo(price) < 0) {
                byPrice.add(product);
            }
        }
        return byPrice;
    }

    @GetMapping("/by-understring/{string}")
    public List<Product> getProductByString(@PathVariable String string){
        List<Product> allProducts = productService.getAllProducts();
        List<Product> bySting = new ArrayList<Product>();

        for (Product product : allProducts){
            if (product.getName().toLowerCase().contains(string)){
                bySting.add(product);
            }
        }
        return bySting;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
