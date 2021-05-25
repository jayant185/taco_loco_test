package com.taco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taco.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Modifying
	@Query("UPDATE Order SET final_payable_amount=?1 WHERE id=?2")
	void updatePrice(String finalPayableAmount, int id);
}
