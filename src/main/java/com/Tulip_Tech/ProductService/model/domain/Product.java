package com.Tulip_Tech.ProductService.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String productName;
    private long price;
    private long quantity;
}
