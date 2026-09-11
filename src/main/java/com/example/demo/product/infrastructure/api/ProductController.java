package com.example.demo.product.infrastructure.api;

import com.example.demo.common.mediator.Mediator;
import com.example.demo.product.application.command.delete.DeleteProductRequest;
import com.example.demo.product.application.query.getAll.GetAllProductsRequest;
import com.example.demo.product.application.query.getById.GetProductByIdRequest;
import com.example.demo.product.infrastructure.api.dto.ProductDto;
import com.example.demo.product.infrastructure.api.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements IProductApi {

    private final Mediator mediator;
    private final IProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) Integer pageSize) {
        var request = new GetAllProductsRequest();
        request.setPageSize(pageSize);
        var result = mediator.dispatch(request).getProducts();
        return ResponseEntity.ok(result.stream()
                .map(productMapper::mapToProductDto)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var request = new GetProductByIdRequest(id);
        var result = mediator.dispatch(request).getProduct();
        return ResponseEntity.ok(productMapper.mapToProductDto(result));
    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        var request = productMapper.mapToCreateProductRequest(productDto);
        mediator.dispatch(request);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
        var request = productMapper.mapToUpdateProductRequest(productDto);
        mediator.dispatch(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        var request = new DeleteProductRequest();
        request.setId(id);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();
    }

}
