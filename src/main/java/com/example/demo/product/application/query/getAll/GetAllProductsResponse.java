package com.example.demo.product.application.query.getAll;

import com.example.demo.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetAllProductsResponse {

    private List<Product> products;
}
