package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Page<Category> getPaginatedCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public Category getCategoryById(int id) {
        return categoryRepository.getOne(id);
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.delete(id);;
	}
}
