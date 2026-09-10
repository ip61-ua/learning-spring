package com.example.demo.product.infrastructure.database;

import com.example.demo.product.domain.Product;
import com.example.demo.product.domain.ProductRepository;
import com.example.demo.product.infrastructure.database.entity.ProductEntity;
import com.example.demo.product.infrastructure.database.mapper.IProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>();

    private final IProductEntityMapper productEntityMapper;

    @Override
    public void upsert(Product product) {
        products.add(productEntityMapper.mapToProductEntity(product));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return products.stream().map(productEntityMapper::mapToProduct).toList();
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf((p) -> p.getId().equals(id));
    }
}
