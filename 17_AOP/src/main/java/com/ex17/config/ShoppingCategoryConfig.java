package com.ex17.config;

import com.ex17.service.ShoppingCategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ex17.entity.Product;

@PropertySource("classpath:discounts.properties")
@EnableAspectJAutoProxy
@ComponentScan("com.ex17")
public class ShoppingCategoryConfig {

    @Value("${specialcustomer.discount:0}")
    private int specialCustomerDiscount;

    @Value("${summer.discount:0}")
    private int specialSummerDiscount;

    @Value("${product.discount:0}")
    private int productDiscount;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product asus() {
        return  new Product("ASUS", 65000, specialSummerDiscount);
    }

    @Bean
    public Product redmi() {
        return new Product("REDMI", 57000, productDiscount);
    }

    @Bean
    public Product hp() {
        return new Product("HP", 70000, specialSummerDiscount);
    }

    @Bean
    public Product oneplus() {
        return new Product("ONEPLUS", 55000, specialSummerDiscount);
    }

    @Bean
    public Product samsung() {
        return new Product("SAMSUNG", 62000, specialCustomerDiscount);
    }

}
