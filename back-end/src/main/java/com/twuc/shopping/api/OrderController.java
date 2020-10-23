package com.twuc.shopping.api;

import com.twuc.shopping.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
