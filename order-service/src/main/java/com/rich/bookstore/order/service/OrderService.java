package com.rich.bookstore.order.service;

import com.rich.bookstore.order.exception.EntityNotFoundException;
import com.rich.bookstore.order.exception.InventoryInsufficientException;
import com.rich.bookstore.order.repository.entity.Item;
import com.rich.bookstore.order.repository.entity.Order;
import com.rich.bookstore.order.service.client.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    private RestTemplate restTemplate;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    public OrderService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void createOrder(Order order) {
        isQuantitySufficient(order);
    }


    public void isQuantitySufficient(Order order) {
        Item item = inventoryService.getItemById(order.getItemId());
        if(item == null) {
            throw new EntityNotFoundException("Item not found", order.getItemId());
        }

        if(item.getQuantity() < order.getQuantity()) {
            throw new InventoryInsufficientException("Item inventory insufficient", order.getItemId(),
                    item.getQuantity(), order.getQuantity());
        }
    }
}
