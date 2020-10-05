package com.example.junittest;

import com.example.junittest.controller.ProductController;
import com.example.junittest.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class JunitTestApplicationTests {
    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;

    @Test
    public void whenUserIdProvided_thenRetrievedProductNameIsCorrect(){
        Mockito.when(productService.getProductName()).thenReturn("Car 123");
        String testName = productController.getProductName();
        Assert.assertEquals("Car 123",testName);
    }


}
