package com.example.cnuorder.dto;

import com.example.cnuorder.entity.Category;
import lombok.Getter;

public record CreateProductRequest(String productName, Category category, long price, String description) {
}
