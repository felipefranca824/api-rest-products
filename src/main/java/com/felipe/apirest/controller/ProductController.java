package com.felipe.apirest.controller;

import java.util.List;

import com.felipe.apirest.models.Product;
import com.felipe.apirest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
    
    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id") long id){
        return repository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product){
        repository.delete(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return repository.save(product);
    }
}
