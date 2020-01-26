package com.example.spring_mvc_shopping.service;

import com.example.spring_mvc_shopping.domain.Category;
import com.example.spring_mvc_shopping.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
      return this.categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id + "is not found"));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
