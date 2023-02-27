package com.example.cnuorder.controller;

import com.example.cnuorder.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productPage(Model model) {
        var products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }
}
