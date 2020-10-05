package com.example.restfulwebservicetest;

import com.example.restfulwebservicetest.config.AbstractTest;
import com.example.restfulwebservicetest.controller.ProductController;
import com.example.restfulwebservicetest.model.Product;
import com.example.restfulwebservicetest.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("controller")
public class RestfulWebServiceTestApplicationTests extends AbstractTest {
    private static List<Product> productRepo = new ArrayList<>();
    static {
        Product car = new Product();
        car.setId("1");
        car.setName("Merc");
        productRepo.add(car);


        Product phone = new Product();
        phone.setId("2");
        phone.setName("Apple");
        productRepo.add(phone);
    }
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;

    @Test
    public void getProduct() throws Exception {
        String url = "/get";
        Mockito.when(productService.getProduct()).thenReturn((productRepo));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200 , status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] products = mapFromJson(content,Product[].class);
        for(int i = 0 ; i < products.length;i++){
            Assert.assertEquals(productController.getProduct().getBody().get(i).getId(),products[i].getId());
            Assert.assertEquals(productController.getProduct().getBody().get(i).getName(),products[i].getName());
        }
    }
    @Test
    public void creatProduct() throws Exception {
        String url = "/create";
        Product product = new Product();
        product.setId("3");
        product.setName("Adidas");
        String input = mapToJson(product);
        Mockito.when(productService.createProduct(product)).thenReturn("Create Successful");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200,status);
        Assert.assertEquals("Create Successful",productController.creatProduct(product));
    }
    @Test
    public void updateProduct() throws Exception {
        String url = "/update/3";
        Product product = new Product();
        product.setName("Nike");
        String input = mapToJson(product);
        Mockito.when(productService.updateProduct("3",product)).thenReturn("Update Successful");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200,status);
        Assert.assertEquals("Update Successful",productController.updateProduct("3",product));
    }
    @Test
    public void deleteProduct() throws Exception {
        String url = "/delete/3";
        Mockito.when(productService.deleteProduct("3")).thenReturn("Delete Successful");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(url).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200,status);
        Assert.assertEquals("Delete Successful",productController.deleteProdut("3"));
    }
}
