package com.Tulip_Tech.ProductService.service;

import com.Tulip_Tech.ProductService.exception.custom.NotFoundException;
import com.Tulip_Tech.ProductService.exception.custom.ProductCustomException;
import com.Tulip_Tech.ProductService.model.domain.Product;
import com.Tulip_Tech.ProductService.model.dto.CreateProductRequest;
import com.Tulip_Tech.ProductService.model.dto.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    Long addProduct(CreateProductRequest request);

    Product getProductById(Long productId) throws NotFoundException;

    List<Product> getAllProducts();

    void deleteById(Long id)throws NotFoundException;

    Product update(Long id, UpdateProductRequest product) throws NotFoundException;

    void reduceQuantity(Long id, long quantity)throws ProductCustomException;
}
