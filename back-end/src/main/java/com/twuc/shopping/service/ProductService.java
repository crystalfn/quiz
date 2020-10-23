package com.twuc.shopping.service;

import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.exception.ProductExitsException;
import com.twuc.shopping.repository.ProductRepository;
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

    public List<ProductDto> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities
            .stream()
            .map(ProductDto::convertProductEntityToProduct)
            .collect(Collectors.toList());
    }

    public void addProduct(ProductDto productDto) throws ProductExitsException {
        final List<ProductEntity> productEntities = productRepository.findAll();
        for (ProductEntity productEntity : productEntities) {
            if (productEntity.getName().equals(productDto.getName())) {
                throw new ProductExitsException("Product exist!");
            }
        }
        ProductEntity productEntity = ProductEntity.convertProductToProductEntity(productDto);
        productRepository.save(productEntity);
    }
}
