package com.talleyouro.springwebdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductsRepository productsRepository;

    @Autowired
    public HomeController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @GetMapping("/")
    public String Home(Model model){
        var products = productsRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }
}
