package com.ecommerce.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.learn.model.Order;


public interface OrderRepository extends JpaRepository<Order,Long>{
	 

}
