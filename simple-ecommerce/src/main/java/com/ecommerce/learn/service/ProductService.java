package com.ecommerce.learn.service;

//import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.ecommerce.learn.model.Product;

@Validated
public interface ProductService {
	
	public @NotNull Iterable<Product> getAllProducts();
	public Product getProduct(long id);
	public Product save(Product product);
}
