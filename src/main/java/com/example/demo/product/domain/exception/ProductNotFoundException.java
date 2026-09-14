package com.example.demo.product.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("The product with ID ".concat(id.toString()).concat(" does not exist"));
    }
}
