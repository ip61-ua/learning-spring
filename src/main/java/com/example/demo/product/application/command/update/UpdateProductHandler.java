package com.example.demo.product.application.command.update;

import com.example.demo.common.mediator.IRequestHandler;
import com.example.demo.product.domain.entity.Product;
import com.example.demo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductHandler implements IRequestHandler<UpdateProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(UpdateProductRequest request) {
        var product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();

        productRepository.upsert(product);
        return null;
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
