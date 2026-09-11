package com.example.demo.product.application.command.update;

import com.example.demo.common.mediator.IRequest;
import lombok.Data;

@Data
public class UpdateProductRequest implements IRequest<Void> {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String image;

}
