package com.example.cnuorder.repository;

import com.example.cnuorder.entity.Category;
import com.example.cnuorder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAll();
    Product save(Product product);
    Optional<Product> findById(UUID productId);
    Optional<Product> findByProductName(String productName);
    List<Product> findByCategory(Category category);
    void deleteAll();
}
