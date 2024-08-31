package in.ac.jssateb.mallmanagement.controller;

import in.ac.jssateb.mallmanagement.model.Order;
import in.ac.jssateb.mallmanagement.model.Item;
import in.ac.jssateb.mallmanagement.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order newOrder = orderService.addOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> searchOrder(@PathVariable long id) {
        Order order = orderService.searchOrder(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> cancelMall(@PathVariable long id) {
        boolean result = orderService.cancelMall(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item newItem = orderService.addItem(item);
        return ResponseEntity.ok(newItem);
    }
    
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}