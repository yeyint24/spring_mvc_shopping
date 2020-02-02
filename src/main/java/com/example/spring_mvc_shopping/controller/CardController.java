package com.example.spring_mvc_shopping.controller;

import com.example.spring_mvc_shopping.domain.Cart;
import com.example.spring_mvc_shopping.domain.Product;
import com.example.spring_mvc_shopping.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CardController{

    private  final Cart cart;
    private  final ProductService productService;
    public CardController(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }
    @GetMapping("/cart/add/{id}")
    public String addToCard(@PathVariable int id, HttpServletRequest request){
        boolean isExisted=false;
        for (Product product:cart.getCardItems()){
            if(product.getId()==id){
                isExisted=true;
            }
        }
        if(!isExisted) {
            cart.addToCard(productService.findById(id));
        }
        HttpSession session=request.getSession();
        session.setAttribute("cartSize",cart.cardSize());
        return "redirect:/products/"+id;
    }
}
