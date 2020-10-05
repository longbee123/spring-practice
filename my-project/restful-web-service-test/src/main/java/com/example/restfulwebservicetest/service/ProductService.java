package com.example.restfulwebservicetest.service;

import com.example.restfulwebservicetest.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product car = new Product();
        car.setId("1");
        car.setName("Merc");
        productRepo.put(car.getId(),car);


        Product phone = new Product();
        phone.setId("2");
        phone.setName("Apple");
        productRepo.put(phone.getId(),phone);
    }
    public List<Product> getProduct(){
        List<Product> list = new ArrayList<>();
        list.addAll(productRepo.values());
        return list;
    }
    public String updateProduct(String id , Product product){
        productRepo.remove(id);
        productRepo.put(product.getId(),product);
        return "Update Successful";
    }
    public String createProduct(Product product){
        productRepo.put(product.getId(),product);
        return "Create Successful";
    }
    public String deleteProduct(String id){
        productRepo.remove(id);
        return "Delete Successful";
    }
}
