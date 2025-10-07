package com.Tulip_Tech.ProductService.exception.custom;
import org.springframework.http.HttpStatus;

public class ProductCustomException extends RuntimeException {

    HttpStatus status;
    public ProductCustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
