package com.twuc.shopping.api;

import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.exception.ProductExitsException;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {
    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity addProductInOrder(@Valid @RequestBody ProductDto productDto) throws ProductExitsException {
        return ResponseEntity.created(null).build();
    }
}
