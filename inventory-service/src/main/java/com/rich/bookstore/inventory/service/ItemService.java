package com.rich.bookstore.inventory.service;

import com.rich.bookstore.inventory.repository.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemService {

    public static final String ITEM_ID_SET_KEY = "item:ids";
    public static final String ITEM_KEY_PREFIX = "item:data:";

    @Autowired
    private RedisTemplate redisTemplate;

    public void initItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("1", "Kubernetes in action", 10, 650, System.currentTimeMillis()));
        items.add(new Item("2", "Amazon web services action", 5, 450, System.currentTimeMillis()));
        items.add(new Item("3", "Clean Architecture", 5, 500, System.currentTimeMillis()));
        items.add(new Item("4", "Mastering Machine Learning with scikit-learn", 2, 750, System.currentTimeMillis()));

        Set<String> ids = items.stream()
                .map(Item::getId)
                .collect(Collectors.toSet());


        ids.forEach(id -> redisTemplate.opsForSet().add(ITEM_ID_SET_KEY, id));

        items.forEach(item -> {
            String key = ITEM_KEY_PREFIX + item.getId();
            redisTemplate.opsForValue().set(key, item);
        });
    }

    public Item get(String id) {
        return (Item) redisTemplate.opsForValue().get(ITEM_KEY_PREFIX + id);
    }

    public Set<String> getAllIds() {
        return redisTemplate.opsForSet().members(ITEM_ID_SET_KEY);
    }

    public List<Item> getAllItems() {
        Set<String> idSet = redisTemplate.keys(ITEM_KEY_PREFIX + "*");
        return redisTemplate.opsForValue().multiGet(idSet);
    }
}
