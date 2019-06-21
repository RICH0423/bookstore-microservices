package com.rich.bookstore.order.service;

import com.rich.bookstore.order.exception.EntityNotFoundException;
import com.rich.bookstore.order.exception.InventoryInsufficientException;
import com.rich.bookstore.order.repository.entity.Item;
import com.rich.bookstore.order.repository.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    @Value("${api.inventory.getItemById}")
    private String getItemByIdApi;

    private RestTemplate restTemplate;

    private static final boolean INSUFFICIENT = false;
    private static final boolean SUFFICIENT = true;

    @Autowired
    public OrderService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void createOrder(Order order) {
        isQuantitySufficient(order);
    }


    public void isQuantitySufficient(Order order) {
        String uri = String.format(getItemByIdApi, order.getItemId());
        log.debug("The uri of Get item api: {}", uri);

        Item item = restTemplate.getForEntity(uri, Item.class).getBody();
        if(item == null) {
            throw new EntityNotFoundException("Item not found", order.getItemId());
        }

        if(item.getQuantity() < order.getQuantity()) {
            throw new InventoryInsufficientException("Item inventory insufficient", order.getItemId(),
                    item.getQuantity(), order.getQuantity());
        }
    }
}
