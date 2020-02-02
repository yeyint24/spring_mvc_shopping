package com.example.spring_mvc_shopping.service;

import com.example.spring_mvc_shopping.domain.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product findById(int id);
    List<Product> findAll();
    List<Product> findProductByCategory(int id);




}
