package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface ProductService {
	
	/*
	 * Category findCategoryByName(String name);
	 */
	 List<Product> getAllProducts();

	Page<Product> getPaginatedProducts(Pageable pageable);
	
    void saveProduct(Product product);
    
    Product updateProduct(Product product);
    
    Product getProductById(int id);
    
    void deleteProduct(int id);
    
    Category getCategoryById(int id);
	 
}
