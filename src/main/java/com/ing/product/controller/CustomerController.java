package com.ing.product.controller;

import com.ing.product.bean.Product;
import com.ing.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "ING Customer Product API")
@RestController
@RequestMapping(value = "v1/customers")
@AllArgsConstructor
public class CustomerController {

    private ProductService productService;

    @ApiOperation(value = "Get Customer products")
    @GetMapping(value = "/{customerId}/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getProducts(@NonNull @PathVariable Long customerId) {
        return Optional.of(productService.getCustomerProducts(customerId))
                .map(products -> ResponseEntity.status(HttpStatus.CREATED).body(products))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

}
