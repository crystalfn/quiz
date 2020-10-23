package com.twuc.shopping.api;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.exception.ProductExitsException;
import com.twuc.shopping.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductsController {
    final
    ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllEvents() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@Valid @RequestBody Product product) throws ProductExitsException {
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            throw new ProductExitsException("Product exits!");
        }
        return ResponseEntity.created(null).build();
    }
}
