package com.rich.bookstore.inventory.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    private String name;
    private long quantity;
    private long price;
    private long createAt;

}
