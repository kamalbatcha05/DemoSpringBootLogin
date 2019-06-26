package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		System.out.println("=========Products========" + products);
		modelAndView.addObject("products", products);
		products.parallelStream().forEach(f -> {
			System.out.println(f.getProductName());
		});
		modelAndView.setViewName("productList");
		return modelAndView;
	}
	
}
