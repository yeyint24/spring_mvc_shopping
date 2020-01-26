package com.example.spring_mvc_shopping.controller;

import com.example.spring_mvc_shopping.domain.Category;
import com.example.spring_mvc_shopping.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "admin/adminForm";
    }
    @PostMapping("/category")
    public String process(Category category, BindingResult result){
        if(result.hasErrors()){
            return "admin/adminForm";
        }
        categoryService.create(category);
        return "redirect:/categories";

    }


}
