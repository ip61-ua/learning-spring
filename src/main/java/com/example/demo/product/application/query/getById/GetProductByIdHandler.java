package com.example.demo.product.application.query.getById;

import com.example.demo.common.mediator.IRequestHandler;
import com.example.demo.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductByIdHandler implements IRequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {
        return new GetProductByIdResponse(productRepository
                .findById(request.getId())
                .orElse(null));
        //.orElseThrow(() -> new RuntimeException("Product not found")));
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
