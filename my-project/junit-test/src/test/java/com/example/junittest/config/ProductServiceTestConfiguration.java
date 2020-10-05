package com.example.junittest.config;


import com.example.junittest.service.ProductService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ProductServiceTestConfiguration {

    @Bean
    @Primary
    public ProductService productService(){
        return Mockito.mock(ProductService.class);
    }

}
