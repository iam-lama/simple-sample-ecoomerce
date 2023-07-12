package com.ecommerce.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.learn.model.OrderProduct;
import com.ecommerce.learn.model.OrderProductPK;


public interface OrderProductRepository extends JpaRepository<OrderProduct,OrderProductPK> {

}
