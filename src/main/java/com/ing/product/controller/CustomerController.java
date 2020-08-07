package com.ing.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @RequestMapping("/{customerId}/products")
    public void getProducts() {

    }
}
