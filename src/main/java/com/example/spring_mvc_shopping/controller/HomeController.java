package com.example.spring_mvc_shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String welcome(){
        return "layout/userlayout";
    }
}
