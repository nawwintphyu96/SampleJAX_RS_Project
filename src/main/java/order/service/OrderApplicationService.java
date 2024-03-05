package order.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import order.model.Order;

public class OrderApplicationService implements IOrderApplicationService {
	private static List<Order> list = new ArrayList<Order>();

	@Override
	public List<Order> getAllOrders() {

		addOrders();
		return list;
	}

	@Override
	public Order getOrderById(Integer id) {
		// TODO Auto-generated method stub
		addOrders();
		return list.get(id);
	}

	@Override
	public List<Order> addOrders() {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setId(1);
		order.setName("Apple Watch");
		order.setDescription("Cash In Delivery.White");
		order.setOrderDate(LocalDateTime.now());
		Order order1 = new Order();
		order1.setId(1);
		order1.setName("Apple Watch");
		order1.setDescription("Cash In Delivery.White");
		order1.setOrderDate(LocalDateTime.now());
		Order order2 = new Order();
		order2.setId(1);
		order2.setName("Apple Watch");
		order2.setDescription("Cash In Delivery.White");
		order2.setOrderDate(LocalDateTime.now());
		list.add(order1);
		list.add(order2);
		list.add(order);
		return list;
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		Order newOrder = new Order();
		newOrder.setId(order.getId());
		newOrder.setName(order.getName());
		newOrder.setDescription(order.getDescription());
		newOrder.setOrderDate(LocalDateTime.now());
		return newOrder;
	}

}
