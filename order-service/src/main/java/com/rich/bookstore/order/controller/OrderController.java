package com.rich.bookstore.order.controller;

import com.rich.bookstore.order.repository.entity.Order;
import com.rich.bookstore.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public void getOrders() {
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }
}
