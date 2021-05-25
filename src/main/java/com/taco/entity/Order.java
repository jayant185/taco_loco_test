package com.taco.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "orders")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_contact_no")
	private String customerContactNo;

	@Column(name = "datetime")
	private String datetime;

	@Column(name = "final_payable_amount")
	private String finalPayableAmount;

	@Transient
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItem> orderItems;

	@Transient
	private List<OrderItem> items;

	public Order() {
	}

	public Order(int id, String customerName, String customerContactNo, String datetime, String finalPayableAmount,
			Set<OrderItem> orderItems, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
		this.datetime = datetime;
		this.finalPayableAmount = finalPayableAmount;
		this.orderItems = orderItems;
		this.items = items;
	}

	public String getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public String getFinalPayableAmount() {
		return finalPayableAmount;
	}

	public void setFinalPayableAmount(String finalPayableAmount) {
		this.finalPayableAmount = finalPayableAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", customerContactNo=" + customerContactNo
				+ ", datetime=" + datetime + ", finalPayableAmount=" + finalPayableAmount + ", items=" + items + "]";
	}
}
