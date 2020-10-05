//package com.example.restfulwebservicetest.test;
//
//
//import com.example.restfulwebservicetest.config.AbstractTest;
//import com.example.restfulwebservicetest.controller.ProductController;
//
//import com.example.restfulwebservicetest.model.Product;
//import com.example.restfulwebservicetest.service.ProductService;
//import org.junit.Assert;
//import org.junit.Before;
//
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class ProductControllerTest extends AbstractTest {
//    private static Map<String, Product> productRepo = new HashMap<>();
//    static {
//        Product car = new Product();
//        car.setId("1");
//        car.setName("Merc");
//        productRepo.put(car.getId(),car);
//
//
//        Product phone = new Product();
//        phone.setId("2");
//        phone.setName("Apple");
//        productRepo.put(phone.getId(),phone);
//    }
//    @Override
//    @Before
//    public void setUp() {
//        super.setUp();
//    }
//
//    @Autowired
//    private ProductController productController;
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    public void getProduct() throws Exception {
//        String url = "/get";
//        Mockito.when(productService.getProduct()).thenReturn(productRepo.values());
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        Assert.assertEquals(200 , status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Product[] products = mapFromJson(content,Product[].class);
//        Assert.assertEquals(productController.getProduct(), ResponseEntity.ok(products));
//    }
//}
