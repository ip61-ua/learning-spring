package com.example.demo.product.application.query.getAll;

import com.example.demo.common.mediator.IRequest;
import lombok.Data;

@Data
public class GetAllProductsRequest implements IRequest<GetAllProductsResponse> {

    private Integer pageSize;
}
