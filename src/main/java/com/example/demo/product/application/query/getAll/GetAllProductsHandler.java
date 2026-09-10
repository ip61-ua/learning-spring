package com.example.demo.product.application.query.getAll;

import com.example.demo.common.mediator.IRequestHandler;
import com.example.demo.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllProductsHandler implements IRequestHandler<GetAllProductsRequest, GetAllProductsResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductsResponse handle(GetAllProductsRequest request) {
        var pageSize = request.getPageSize();
        var result = productRepository.findAll();
        var totalSize = result.size();
        var finalPageSize = (pageSize == null || pageSize < 0 || totalSize < pageSize) ? totalSize : pageSize;

        return new GetAllProductsResponse(result.subList(0, finalPageSize));
    }

    @Override
    public Class<GetAllProductsRequest> getRequestType() {
        return GetAllProductsRequest.class;
    }
}
