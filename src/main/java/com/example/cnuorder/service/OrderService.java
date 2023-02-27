package com.example.cnuorder.service;

import com.example.cnuorder.entity.Order;
import com.example.cnuorder.entity.OrderItem;

import java.util.List;

public interface OrderService {
    Order createOrder(String email, String address, String postcode, List<OrderItem> orderItems);
}
