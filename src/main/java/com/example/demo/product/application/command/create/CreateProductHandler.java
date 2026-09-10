package com.example.demo.product.application.command.create;

import com.example.demo.common.mediator.IRequestHandler;
import com.example.demo.product.domain.Product;
import com.example.demo.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductHandler implements IRequestHandler<CreateProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .id(request.getId())
                .build();

        productRepository.upsert(product);

        return null;
    }

    @Override
    public Class<CreateProductRequest> getRequestType() {
        return CreateProductRequest.class;
    }
}
