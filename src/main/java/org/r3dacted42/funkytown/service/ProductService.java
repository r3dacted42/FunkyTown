package org.r3dacted42.funkytown.service;

import lombok.RequiredArgsConstructor;
import org.r3dacted42.funkytown.dto.ProductRequest;
import org.r3dacted42.funkytown.entity.Product;
import org.r3dacted42.funkytown.mapper.ProductMapper;
import org.r3dacted42.funkytown.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public String createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        productRepo.save(product);
        return "Product created";
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getTopTwoProductsInPriceRange(double priceMin, double priceMax) {
        return productRepo.findTopTwoByPriceDescAndPriceBetween(priceMin, priceMax);
    }
}
