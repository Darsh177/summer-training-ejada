package com.example.demo.repository;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldFindProductsAndVerifyAuditingAndProjection() {
        Product product = Product.builder()
                .name("Laptop")
                .category("Electronics")
                .price(BigDecimal.valueOf(1200))
                .build();

        Product savedProduct = productRepository.save(product);

        List<Product> result = productRepository.findByCategory("Electronics");
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Laptop");

        assertThat(savedProduct.getCreatedAt()).isNotNull();

        List<ProductSummaryDto> summaries = productRepository.findSummaryByCategory("Electronics");
        assertThat(summaries).hasSize(1);
        assertThat(summaries.get(0).getName()).isEqualTo("Laptop");
    }
}