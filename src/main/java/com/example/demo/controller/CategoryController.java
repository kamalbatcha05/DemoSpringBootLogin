package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.Constants;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public ModelAndView viewAddCategory() {
		ModelAndView modelAndView = new ModelAndView();
		Category category = new Category();
		modelAndView.addObject("category", category);
		modelAndView.setViewName("add-category");
		return modelAndView;
	}

	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public ModelAndView saveCategory(@Valid Category category, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		category.setStatus(null != category && null != category.getStatus() ?
				category.getStatus() : Constants.ACTIVE);
		
        if (!bindingResult.hasErrors()) {
        	categoryService.saveCategory(category);
    		modelAndView.addObject("successMessage", "Category added successfully");
    		modelAndView.addObject("category", new Category());

        }
		modelAndView.setViewName("add-category");
		return modelAndView;
	}

	@RequestMapping(value = "/category-list/page/{page}")
	public ModelAndView listCategorysPageByPage(@PathVariable("page") int page) {
		ModelAndView modelAndView = new ModelAndView("categoryList");
		PageRequest pageable = new PageRequest(page - 1, 4);
		Page<Category> categoryPage = categoryService.getPaginatedCategories(pageable);

		int totalPages = categoryPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			modelAndView.addObject("pageNumbers", pageNumbers);
			modelAndView.addObject("lastPageNumber", pageNumbers.get(pageNumbers.size() - 1));
		}
		modelAndView.addObject("activeCategoryList", true);
		modelAndView.addObject("currentPageNumber", page);
		modelAndView.addObject("categories", categoryPage.getContent());
		return modelAndView;
	}

	@RequestMapping(value = "/view-category/{id}", method = RequestMethod.GET)
	public ModelAndView viewCategory(@PathVariable("id") int categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		Category category = categoryService.getCategoryById(categoryId);
		modelAndView.addObject("category", category);
		modelAndView.setViewName("view-category");
		return modelAndView;
	}

	@RequestMapping(value = "/edit-category/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("id") int categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		Category category = categoryService.getCategoryById(categoryId);
		String[] statusValues = new String[] {Constants.ACTIVE, Constants.IN_ACTIVE};
		modelAndView.addObject("statusValues", Arrays.asList(statusValues));
		modelAndView.addObject("category", category);
		modelAndView.setViewName("update-category");
		return modelAndView;
	}

	@RequestMapping(value = "/update-category", method = RequestMethod.PUT)
	public ModelAndView updateCategory(@Valid Category category, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		category = categoryService.updateCategory(category);
        String[] statusValues = new String[] {Constants.ACTIVE, Constants.IN_ACTIVE};
		modelAndView.addObject("statusValues", Arrays.asList(statusValues));
		modelAndView.addObject("successMessage", "Category updated successfully");
		modelAndView.addObject("category", category);
		modelAndView.setViewName("update-category");

		return modelAndView;
	}
	 


}
