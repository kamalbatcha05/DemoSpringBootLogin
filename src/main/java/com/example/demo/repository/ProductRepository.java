package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    Product findProductByName(String name);

	Page<Product> findAll(Pageable pageable);
}