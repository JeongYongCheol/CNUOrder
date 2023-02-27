package com.example.cnuorder.service;

import com.example.cnuorder.entity.Category;
import com.example.cnuorder.entity.Product;
import com.example.cnuorder.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String productName, Category category, long price, String description) {
        var product = Product.builder()
                .productId(UUID.randomUUID())
                .productName(productName)
                .category(category)
                .price(price)
                .description(description)
                .build();
        return productRepository.save(product);
    }
}
