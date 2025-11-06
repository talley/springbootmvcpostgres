package com.talleyouro.springwebdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/products")
    public String list(Model model) {
       var products = productsRepository.findAll();
       model.addAttribute("products", products);
       return "products";
    }

    @GetMapping("/products/edit")
    public String edit(@RequestParam(value = "id", required = true) Long id, Model model) {
        var product=productsRepository.findById(id).get();
        model.addAttribute("product", product);
        return "edit_product";
    }
}
