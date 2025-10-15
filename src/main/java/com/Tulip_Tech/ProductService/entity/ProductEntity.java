package com.Tulip_Tech.ProductService.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity(name = "PRODUCT")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Setter
    @Column(name = "product_name")
    private String productName;

    @Setter
    @Column(name = "price")
    private long price;

    @Setter
    @Column(name = "quantity")
    private long quantity;


}
