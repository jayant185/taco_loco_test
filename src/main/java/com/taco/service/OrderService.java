package com.taco.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taco.entity.Order;
import com.taco.repo.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Optional<Order> findById(int id) {
		return orderRepository.findById(id);
	}

	public int save(Order order) {
		return orderRepository.save(order).getId();		
	}

	public void update(Order order) {
		orderRepository.save(order);
	}

	public void updatePrice(String finalPayableAmount, int id) {
		orderRepository.updatePrice(finalPayableAmount, id);
	}
	
	public void delete(int id) {
		orderRepository.deleteById(id);
	}
}
