package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		/*ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		System.out.println("=========Products========" + products);
		modelAndView.addObject("products", products);
		products.parallelStream().forEach(f -> {
			System.out.println(f.getProductName());
		});
		modelAndView.setViewName("productList");
		return modelAndView;*/
		ModelAndView modelAndView = new ModelAndView("productListPaging");
        PageRequest pageable = new PageRequest(0, 9);
        Page<Product> productPage = productService.getPaginatedProducts(pageable);
        
        
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed()
            		.collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
            modelAndView.addObject("lastPageNumber", pageNumbers.get(pageNumbers.size() - 1));
        }
        modelAndView.addObject("activeProductList", true);
        modelAndView.addObject("currentPageNumber", 1);
        modelAndView.addObject("productList", productPage.getContent());
        return modelAndView;
	}
	
	@RequestMapping(value = "/products/page/{page}")
    public ModelAndView listProductsPageByPage(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("productListPaging");
        PageRequest pageable = new PageRequest(page - 1, 9);
        Page<Product> productPage = productService.getPaginatedProducts(pageable);
        
        
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed()
            		.collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
            modelAndView.addObject("lastPageNumber", pageNumbers.get(pageNumbers.size() - 1));
        }
        modelAndView.addObject("activeProductList", true);
        modelAndView.addObject("currentPageNumber", page);
        modelAndView.addObject("productList", productPage.getContent());
        return modelAndView;
    }
	
}
