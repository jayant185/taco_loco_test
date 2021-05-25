package com.taco.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taco.entity.Order;
import com.taco.entity.OrderItem;
import com.taco.repo.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}

	public Optional<OrderItem> findById(int id) {
		return orderItemRepository.findById(id);
	}

	public void saveOrUpdate(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

	public void delete(int id) {
		orderItemRepository.deleteById(id);
	}

	public List<OrderItem> findByOrder(Order order) {
		return orderItemRepository.findByOrder(order);
	}
}
