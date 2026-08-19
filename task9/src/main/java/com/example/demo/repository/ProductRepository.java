package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Long> {

    List<Product> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findProductsExpensiveThan(@Param("minPrice") BigDecimal minPrice);

    List<ProductSummaryDto> findSummaryByCategory(String category);

}
