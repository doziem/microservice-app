package com.doziem.product.product.repository;

import com.doziem.product.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findAllByProductIdInOrderByProductId(List<String > ids);
}
