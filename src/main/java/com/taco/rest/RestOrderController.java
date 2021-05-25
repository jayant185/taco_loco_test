package com.taco.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taco.entity.Order;
import com.taco.service.OrderItemService;
import com.taco.service.OrderService;

@RestController
@RequestMapping("/v1/api/orders")
public class RestOrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping
	public List<Order> findAll() {
		/*List<Order> orders = orderService.findAll();
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).setItems(orderItemService.findByOrder(orders.get(i)));
		}*/
		return orderService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Order> findById(@PathVariable int id) {
		return orderService.findById(id);
	}

	@PostMapping
	public Optional<Order> save(@RequestBody Order order) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		order.setDatetime(formatter.format(date));

		int id = orderService.save(order);
		double finalPayableAmount = 0;
		int quantity = 0;

		for (int i = 0; i < order.getItems().size(); i++) {
			order.getItems().get(i).setOrder(order);
			orderItemService.saveOrUpdate(order.getItems().get(i));

			finalPayableAmount += (order.getItems().get(i).getBasePrice() * order.getItems().get(i).getQuantity());
			quantity += order.getItems().get(i).getQuantity();
		}
		if (quantity >= 4) {
			finalPayableAmount -= ((finalPayableAmount * 20) / 100);
		}
		orderService.updatePrice(String.valueOf(finalPayableAmount), id);
		return orderService.findById(id);
	}

	@PutMapping
	public List<Order> update(@RequestBody Object order) {
		return orderService.findAll();
	}

	@DeleteMapping
	public String delete(@PathVariable int id) {
		orderService.delete(id);
		return "Order deleted successfully.";
	}
}
