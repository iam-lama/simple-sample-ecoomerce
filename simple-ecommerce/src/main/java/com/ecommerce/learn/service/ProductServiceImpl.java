package com.ecommerce.learn.service;


//import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import com.ecommerce.learn.model.Product;
import com.ecommerce.learn.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository ;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {	
//		String reason = "Product not found";
		return productRepository
		          .findById(id)
		          .orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

}
