package com.example.cnuorder.service;

import com.example.cnuorder.entity.OrderItem;

import java.util.UUID;

public interface OrderItemService {
    OrderItem createOrderItem(UUID orderId, OrderItem orderItem);
}
