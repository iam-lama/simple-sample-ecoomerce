package com.ecommerce.learn.controllert;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.learn.model.Product;
import com.ecommerce.learn.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {
	
	@Autowired 
	private ProductService productService;
	
	@GetMapping(value= {"", "/"})
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

}
