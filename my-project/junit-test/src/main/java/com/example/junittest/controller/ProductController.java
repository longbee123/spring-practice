package com.example.junittest.controller;

import com.example.junittest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public String getProductName(){
        return productService.getProductName();
    }
}
