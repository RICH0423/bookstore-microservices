package com.rich.bookstore.order.service.client;

import com.rich.bookstore.order.repository.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="${service.inventory}", path="${api.inventory.item}")
public interface InventoryService {

    @GetMapping("/{id}")
    Item getItemById(@PathVariable("id") String id);

    @GetMapping
    List<Item> getItems();
}
