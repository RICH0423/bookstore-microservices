package com.rich.bookstore.inventory.controller;


import com.rich.bookstore.inventory.repository.entity.Item;
import com.rich.bookstore.inventory.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author rich
 */
@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/ids")
    public Set<String> getAllItemIds() {
        return itemService.getAllIds();
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        String createdId = itemService.createItem(item);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") String id) {
        return itemService.get(id);
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

}
