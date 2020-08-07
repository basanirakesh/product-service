package com.ing.product.bean;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class Product {

    private Long productId;
    private String productName;
    private ProductGroup productGroup;


}
