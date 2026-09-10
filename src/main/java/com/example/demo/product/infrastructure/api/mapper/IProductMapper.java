package com.example.demo.product.infrastructure.api.mapper;

import com.example.demo.product.application.command.create.CreateProductRequest;
import com.example.demo.product.domain.Product;
import com.example.demo.product.infrastructure.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface IProductMapper {

    CreateProductRequest mapToCreateProductRequest(ProductDto productDto);

    // GetAllProductsRequest mapToGetAllProductsRequest(Integer pageSize);

    ProductDto mapToProductDto(Product product);
}
