package com.rich.bookstore.inventory.controller;


import com.rich.bookstore.inventory.repository.entity.Item;
import com.rich.bookstore.inventory.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/items")
public class BookItmesController {

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
    public void createItem(@RequestBody Item item) {
    }

    @GetMapping("/{id}")
    public Item getInfoLog(@PathVariable("id") String id) {
        return itemService.get(id);
    }

}
