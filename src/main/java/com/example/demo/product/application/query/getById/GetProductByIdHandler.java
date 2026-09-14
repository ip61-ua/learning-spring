package com.example.demo.product.application.query.getById;

import com.example.demo.common.mediator.IRequestHandler;
import com.example.demo.product.domain.exception.ProductNotFoundException;
import com.example.demo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductByIdHandler implements IRequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {
        var id = request.getId();

        return new GetProductByIdResponse(productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
