package order.service;

import java.util.List;

import order.model.Order;

public interface IOrderApplicationService {
	List<Order> getAllOrders();

	Order getOrderById(Integer id);
	
	List<Order> addOrders();
	
	Order createOrder(Order order);

}
