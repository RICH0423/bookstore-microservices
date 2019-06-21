package com.rich.bookstore.order.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    private int code = HttpStatus.OK.value();
    private String message;
}
