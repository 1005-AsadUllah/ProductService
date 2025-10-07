package com.Tulip_Tech.ProductService.model.dto;

public record CreateProductRequest(String productName,
                                   long price,
                                   long quantity) {
}