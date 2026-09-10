package com.example.demo.product.application.command.create;

import com.example.demo.common.mediator.IRequest;
import lombok.Data;

@Data
public class CreateProductRequest implements IRequest<Void> {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String image;

}
