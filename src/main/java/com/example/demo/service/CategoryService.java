package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();

	Page<Category> getPaginatedCategories(Pageable pageable);
	
    void saveCategory(Category category);
    
    Category getCategoryById(int id);
    
    void deleteCategory(int id);
}
