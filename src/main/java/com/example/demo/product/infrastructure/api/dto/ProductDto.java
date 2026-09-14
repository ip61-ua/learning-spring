package com.example.demo.product.infrastructure.api.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductDto {
    private Long id;

    @NotBlank
    private String name;

    @Length(min = 10, max = 255, message = "Description Length should be as long as Tweet")
    private String description;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "2.00", inclusive = false)
    private Double price;

    private String image;
}
