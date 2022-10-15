package com.example.test.utility;

import org.springframework.stereotype.Component;

/**
 * Modal class to store the product name
 */
@Component
public class Data {

    String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
