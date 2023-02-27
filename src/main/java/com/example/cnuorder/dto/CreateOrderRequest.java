package com.example.cnuorder.dto;

import com.example.cnuorder.entity.OrderItem;

import java.util.List;

public record CreateOrderRequest(
        String email, String address, String postcode, List<OrderItem> orderItems
) {
}
