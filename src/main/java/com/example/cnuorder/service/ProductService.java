package com.example.cnuorder.service;

import com.example.cnuorder.entity.Product;
import com.example.cnuorder.entity.Category;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByCategory(Category category);
    List<Product> getAllProducts();
    Product createProduct(String productName, Category category, long price, String description);
}
