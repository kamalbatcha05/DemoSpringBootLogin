package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
//	@Autowired
//	CategoryRepository categoryRepository;

//	@Override
//	public Category findCategoryByName(String name) {
//		return categoryRepository.findCategoryByName(name);
//	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	
}