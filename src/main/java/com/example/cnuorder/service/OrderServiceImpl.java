package com.example.cnuorder.service;

import com.example.cnuorder.entity.Order;
import com.example.cnuorder.entity.OrderItem;
import com.example.cnuorder.entity.OrderStatus;
import com.example.cnuorder.repository.OrderItemRepository;
import com.example.cnuorder.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    @Override
    public Order createOrder(String email, String address, String postcode, List<OrderItem> orderItems) {
        UUID orderId = UUID.randomUUID();
        Order order = Order.builder()
                .orderId(orderId)
                .email(email)
                .address(address)
                .postcode(postcode)
                .orderStatus(OrderStatus.ACCEPTED)
                .build();
        orderRepository.save(order);
        orderItems.forEach(orderItem -> {
            orderItemService.createOrderItem(orderId, orderItem);
        });
        return order;
    }
}
