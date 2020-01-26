package com.example.spring_mvc_shopping.service;

import com.example.spring_mvc_shopping.domain.Category;

import java.util.List;

public interface CategoryService  {

    Category create(Category category);
    Category findById(int id);
    List<Category> findAll();

}
