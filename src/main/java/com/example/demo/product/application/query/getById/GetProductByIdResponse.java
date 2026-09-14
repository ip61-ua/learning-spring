package com.example.demo.product.application.query.getById;

import com.example.demo.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductByIdResponse {

    private Product product;
}
