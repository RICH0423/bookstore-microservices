package com.rich.bookstore.order.repository;

import com.rich.bookstore.order.repository.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
