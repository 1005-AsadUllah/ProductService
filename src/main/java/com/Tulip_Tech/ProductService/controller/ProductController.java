package com.Tulip_Tech.ProductService.controller;

import com.Tulip_Tech.ProductService.exception.custom.NotFoundException;
import com.Tulip_Tech.ProductService.exception.custom.ProductCustomException;
import com.Tulip_Tech.ProductService.model.domain.Product;
import com.Tulip_Tech.ProductService.model.dto.CreateProductRequest;
import com.Tulip_Tech.ProductService.model.dto.UpdateProductRequest;
import com.Tulip_Tech.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody CreateProductRequest request) {
        Long productId = productService.addProduct(request);
        return ResponseEntity.ok(productId);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)throws NotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id)throws NotFoundException {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest product)throws NotFoundException {
        Product updateProduct = productService.update(id,product);
        return ResponseEntity.ok(updateProduct);
    }
    @PutMapping("reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Long id, @RequestParam long quantity) throws ProductCustomException {
        productService.reduceQuantity(id, quantity);
        return ResponseEntity.ok().build();
    }
}
