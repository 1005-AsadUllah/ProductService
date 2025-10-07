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
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Setter
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Setter
    @Column(name = "PRICE")
    private long price;

    @Setter
    @Column(name = "QUANTITY")
    private long quantity;


}
