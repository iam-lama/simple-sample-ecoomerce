package com.ecommerce.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.learn.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
 
}
