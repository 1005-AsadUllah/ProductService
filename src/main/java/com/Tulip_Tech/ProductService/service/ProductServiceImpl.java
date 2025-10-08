package com.Tulip_Tech.ProductService.service;

import com.Tulip_Tech.ProductService.entity.ProductEntity;
import com.Tulip_Tech.ProductService.exception.custom.NotFoundException;
import com.Tulip_Tech.ProductService.exception.custom.ProductCustomException;
import com.Tulip_Tech.ProductService.mapper.ProductMapper;
import com.Tulip_Tech.ProductService.model.domain.Product;
import com.Tulip_Tech.ProductService.model.dto.CreateProductRequest;
import com.Tulip_Tech.ProductService.model.dto.UpdateProductRequest;
import com.Tulip_Tech.ProductService.repositoy.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final WebClient webClient;

    @Override
    public Long addProduct(CreateProductRequest request) {
        ProductEntity product = productMapper.dtoToEntity(request);
        return productRepository.save(product).getId();
    }

    @Override
    public Product getProductById(Long productId) throws NotFoundException {
        ProductEntity productEntity = this.findById(productId);
        return productMapper.entityToDomain(productEntity);
    }


    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(productMapper::entityToDomain).toList();
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        this.findById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Long id, UpdateProductRequest product) throws NotFoundException {
        ProductEntity productEntity = this.findById(id);
        if (productEntity != null) {
            ProductEntity updatedEntity = productMapper.updateToEntity(product, productEntity);
            productRepository.save(updatedEntity);
        }
        log.info("Updated Product: {}", product.productName());
        return productMapper.entityToDomain(productEntity);
    }

    @Override
    public void reduceQuantity(Long id, long quantity) throws ProductCustomException {
        log.info("Reducing Quantity: {}", quantity);

        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ProductCustomException("Product not found", HttpStatus.NOT_FOUND));

        if (product.getQuantity() < quantity) {
            log.error("Product Quantity Not Enough");
            throw new ProductCustomException("Product not enough", HttpStatus.BAD_REQUEST);
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product quantity updated successfully. New quantity: {}", product.getQuantity());

    }


    private ProductEntity findById(Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Project not found"));
    }
}
