package com.ecommerce.learn.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.learn.model.Order;
import com.ecommerce.learn.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
private OrderRepository orderRepository ;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		
		this.orderRepository = orderRepository;
		
	}
	@Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
	
    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

}
