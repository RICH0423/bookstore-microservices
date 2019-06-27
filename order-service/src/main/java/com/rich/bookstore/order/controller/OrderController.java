package com.rich.bookstore.order.controller;

import com.rich.bookstore.order.repository.entity.Order;
import com.rich.bookstore.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }
}
