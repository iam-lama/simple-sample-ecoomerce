package com.ecommerce.learn.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.ecommerce.learn.model.Order;
@Validated
public interface OrderService {
	
	public @NotNull Iterable<Order> getAllOrders();
	public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);
	public void update(@NotNull(message = "The order cannot be null.") @Valid Order order);

}
