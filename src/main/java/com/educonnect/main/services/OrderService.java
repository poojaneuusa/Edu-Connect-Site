package com.educonnect.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonnect.main.entities.Orders;
import com.educonnect.main.repositories.OrdersRepository;

@Service
public class OrderService {
	@Autowired
	private OrdersRepository ordersRepository;

	public void storeUserOrders(Orders orders) {
		ordersRepository.save(orders);
	}
}