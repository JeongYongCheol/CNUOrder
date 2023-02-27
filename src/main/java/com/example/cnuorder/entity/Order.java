package com.example.cnuorder.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

@Entity
@Getter
@NoArgsConstructor
public class Order {
    @Id
    private UUID orderId;
    private String email;
    private String address;
    private String postcode;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Order(UUID orderId, String email, String address, String postcode, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.email = verifyEmail(email);
        this.address = address;
        this.postcode = postcode;
        this.orderStatus = orderStatus;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void setEmail(String email) {
        this.email = verifyEmail(email);
        this.updatedAt = LocalDateTime.now();
    }

    public void setAddress(String address) {
        this.address = address;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
        this.updatedAt = LocalDateTime.now();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        this.updatedAt = LocalDateTime.now();
    }

    private String verifyEmail(String email) {
        Assert.notNull(email, "address should not be null");
        Assert.isTrue(email.length() >= 4 && email.length() <= 50, "address length must be between 4 and 50 characters.");
        Assert.isTrue(checkRegex(email), "Invalid email address");
        return email;
    }
    private boolean checkRegex(String email) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b", email);
    }

}
