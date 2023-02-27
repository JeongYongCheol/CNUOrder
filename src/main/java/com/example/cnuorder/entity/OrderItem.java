package com.example.cnuorder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private UUID orderId;
    private UUID productId;
    private Category category;
    private long price;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public OrderItem(UUID orderId, UUID productId, Category category, long price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
        this.updatedAt = LocalDateTime.now();
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
        this.updatedAt = LocalDateTime.now();
    }

    public void setCategory(Category category) {
        this.category = category;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPrice(long price) {
        this.price = price;
        this.updatedAt = LocalDateTime.now();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updatedAt = LocalDateTime.now();
    }
}
