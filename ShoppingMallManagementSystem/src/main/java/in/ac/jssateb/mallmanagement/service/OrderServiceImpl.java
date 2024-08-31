package in.ac.jssateb.mallmanagement.service;

import in.ac.jssateb.mallmanagement.model.Order;
import in.ac.jssateb.mallmanagement.model.Item;
import in.ac.jssateb.mallmanagement.repository.OrderRepository;
import in.ac.jssateb.mallmanagement.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> existingOrder = orderRepository.findById(order.getId());
        if (existingOrder.isPresent()) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order searchOrder(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public boolean cancelMall(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}