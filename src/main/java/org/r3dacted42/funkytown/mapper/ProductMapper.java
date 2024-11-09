package org.r3dacted42.funkytown.mapper;

import org.r3dacted42.funkytown.dto.ProductRequest;
import org.r3dacted42.funkytown.dto.ProductResponse;
import org.r3dacted42.funkytown.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toEntity(final ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
    }

    public ProductResponse toResponse(final Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }
}
