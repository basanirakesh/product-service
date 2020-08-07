package com.ing.product.service;

import com.google.common.collect.Lists;
import com.ing.product.bean.Product;
import com.ing.product.bean.ProductGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getCustomerProducts(Long customerId) {
        return Lists.newArrayList(
                Product.builder()
                        .productGroup(ProductGroup.SAVINGS)
                        .productId(1L)
                        .productName("Orange savings account")
                        .build(),
                Product.builder()
                        .productGroup(ProductGroup.SAVINGS)
                        .productId(2L)
                        .productName("Bonus interest account")
                        .build(),
                Product.builder()
                        .productGroup(ProductGroup.SAVINGS)
                        .productId(3L)
                        .productName("Savings deposit")
                        .build(),
                Product.builder()
                        .productGroup(ProductGroup.PAYMENTS)
                        .productId(4L)
                        .productName("Payments account")
                        .build(),
                Product.builder()
                        .productGroup(ProductGroup.MORTGAGE)
                        .productId(5L)
                        .productName("Revolving credit")
                        .build()
        );
    }
}
