package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	
	/*
	 * Category findCategoryByName(String name);
	 */
	 List<Product> getAllProducts();
	 
}
