package com.ing.product.service;

import com.ing.product.bean.Product;
import com.ing.product.bean.ProductGroup;
import com.ing.product.model.ProductEntity;
import com.ing.product.repository.CustomerProductRepository;
import com.ing.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getCustomerProducts(Long customerId) {

        List<Long> productIds = customerProductRepository.getProductIds(customerId);
        List<ProductEntity> productEntities = productRepository.findAllById(productIds);

        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    private Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .productId(productEntity.getId())
                .productName(productEntity.getName())
                .productGroup(ProductGroup.valueOf(productEntity.getType()))
                .build();
    }
}
