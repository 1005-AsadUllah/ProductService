package com.Tulip_Tech.ProductService.repositoy;

import com.Tulip_Tech.ProductService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
