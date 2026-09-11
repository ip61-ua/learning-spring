package com.example.demo.product.application.command.delete;

import com.example.demo.common.mediator.IRequest;
import lombok.Data;

@Data
public class DeleteProductRequest implements IRequest<Void> {

    private Long id;
}
