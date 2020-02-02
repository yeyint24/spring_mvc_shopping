package com.example.spring_mvc_shopping.domain;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Cart {
    private Set<Product>cartItems=new HashSet<>();

    public void addToCard(Product product){
        this.cartItems.add(product);
    }

    public void clearCard(){
        this.cartItems.clear();
    }
    public Set<Product> getCardItems(){
        return this.cartItems;
    }

    public int cardSize(){
        if(cartItems.isEmpty()){
            return 0;
        }
            return this.cartItems.size();
    }

}
