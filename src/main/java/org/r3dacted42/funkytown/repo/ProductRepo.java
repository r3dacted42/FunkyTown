package org.r3dacted42.funkytown.repo;


import org.r3dacted42.funkytown.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceMin AND :priceMax ORDER BY p.price DESC LIMIT 2")
    List<Product> findTopTwoByPriceDescAndPriceBetween(@Param("priceMin")Double priceMin, @Param("priceMax")Double priceMax);
}
