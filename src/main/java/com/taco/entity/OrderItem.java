package com.taco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "order_items")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Order order;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "base_price")
	private double basePrice;

	@Column(name = "quantity")
	private int quantity;

	public OrderItem() {
	}

	public OrderItem(int id, Order order, String productName, double basePrice, int quantity) {
		super();
		this.id = id;
		//this.order = order;
		this.productName = productName;
		this.basePrice = basePrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productName=" + productName + ", basePrice=" + basePrice
				+ ", quantity=" + quantity + "]";
	}
}
