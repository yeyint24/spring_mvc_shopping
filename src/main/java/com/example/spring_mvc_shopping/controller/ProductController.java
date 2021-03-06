package com.example.spring_mvc_shopping.controller;

import com.example.spring_mvc_shopping.domain.Category;
import com.example.spring_mvc_shopping.domain.Product;
import com.example.spring_mvc_shopping.service.CategoryService;
import com.example.spring_mvc_shopping.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductController {


    private Logger logger= LoggerFactory.getLogger(this.getClass());



    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product")
    public String create(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories",categoryService.findAll());
        return "admin/productsForm";
    }
    @PostMapping("/product")
    public String process(Product products, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            model.addAttribute("categories",categoryService.findAll());
            return "admin/productsForm";
        }
        productService.create(products);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/products";
    }
    @GetMapping("/products")

    public String showAllProducts(Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        return "admin/products";
    }
    @GetMapping("/home/category/{id}")
    public String showProductByCategory(@PathVariable int id, Model model){
        model.addAttribute("products",productService.findProductByCategory(id));
        return "user/product";
    }

    @GetMapping("/products/{id}")
    public String findProductById(@PathVariable int id, Model model, HttpServletRequest request){
        model.addAttribute("products",productService.findById(id));
        HttpSession session=request.getSession(false);
        if(session!=null){
            model.addAttribute("cartSize",session.getAttribute("cartSize"));
        }
        return "user/productdetails";
    }




}
