package in.ac.jssateb.mallmanagement.service;

import in.ac.jssateb.mallmanagement.model.Order;

import java.util.List;

import in.ac.jssateb.mallmanagement.model.Item;

public interface OrderService {
    Order addOrder(Order order);
    Order updateOrder(Order order);
    Order searchOrder(long id);
    boolean cancelMall(long id);
    Item addItem(Item item);
	List<Order> getAllOrders();
}
