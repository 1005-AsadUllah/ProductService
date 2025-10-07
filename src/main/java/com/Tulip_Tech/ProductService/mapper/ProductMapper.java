package com.Tulip_Tech.ProductService.mapper;

import com.Tulip_Tech.ProductService.entity.ProductEntity;
import com.Tulip_Tech.ProductService.model.domain.Product;
import com.Tulip_Tech.ProductService.model.dto.CreateProductRequest;
import com.Tulip_Tech.ProductService.model.dto.UpdateProductRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductEntity dtoToEntity(CreateProductRequest request) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(request, productEntity);
        return productEntity;
    }

    public Product entityToDomain(ProductEntity productEntity) {
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    public ProductEntity updateToEntity(UpdateProductRequest product,ProductEntity productEntity) {
        productEntity.setProductName(product.productName());
        return productEntity;
    }

}
