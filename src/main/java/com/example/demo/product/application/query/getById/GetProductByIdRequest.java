package com.example.demo.product.application.query.getById;

import com.example.demo.common.mediator.IRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetProductByIdRequest implements IRequest<GetProductByIdResponse> {

    private Long id;
}
