package com.twuc.shopping.service;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.exception.ProductExitsException;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    final
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities
            .stream()
            .map(Product::convertProductEntityToProduct)
            .collect(Collectors.toList());
    }

    public void addProduct(Product product) throws ProductExitsException {
        final List<ProductEntity> productEntities = productRepository.findAll();
        for (ProductEntity productEntity : productEntities) {
            if (productEntity.getName().equals(product.getName())) {
                throw new ProductExitsException("Product exist!");
            }
        }
        ProductEntity productEntity = ProductEntity.convertProductToProductEntity(product);
        productRepository.save(productEntity);
    }
}
