package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
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
	
	@Override
	public Page<Product> getPaginatedProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = getProductById(product.getId());
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setStatus(product.getStatus());
		existingProduct.setCategory(product.getCategory());
		productRepository.save(existingProduct);
		return existingProduct;
	}
	
	@Override
	public Category getCategoryById(int id) {
        return categoryRepository.getOne(id);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findOne(id);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.delete(id);;
	}
	
}