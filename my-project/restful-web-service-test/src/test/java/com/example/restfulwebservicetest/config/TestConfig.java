package com.example.restfulwebservicetest.config;

import com.example.restfulwebservicetest.service.ProductService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("controller")
public class TestConfig {
    @Bean
    @Primary
    public ProductService productService(){
        return Mockito.mock(ProductService.class);
    }
}
