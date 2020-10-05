package com.example.restfulwebservicetest.controller;


import com.example.restfulwebservicetest.model.Product;
import com.example.restfulwebservicetest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProduct(){
        return ResponseEntity.ok(productService.getProduct());
    }

    @PostMapping("/create")
    public String creatProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable(value = "id") String id , @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProdut(@PathVariable(value = "id") String id){
        return productService.deleteProduct(id);
    }
}
