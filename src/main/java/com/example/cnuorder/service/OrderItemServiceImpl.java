package com.example.cnuorder.service;

import com.example.cnuorder.entity.OrderItem;
import com.example.cnuorder.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(UUID orderId, OrderItem orderItem) {
        return orderItemRepository.save(
                OrderItem.builder()
                        .orderId(orderId)
                        .productId(orderItem.getProductId())
                        .category(orderItem.getCategory())
                        .price(orderItem.getPrice())
                        .quantity(orderItem.getQuantity())
                        .build());
    }
}
