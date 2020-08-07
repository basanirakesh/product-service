package com.ing.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.product.ProductServiceApplication;
import com.ing.product.bean.Product;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class CustomerControllerIntegrationTest {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Get all Customer product.")
    public void getAllCustomerProducts() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        String jsonResponse = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:"+port+"/v1/customers/1/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .getResponse().getContentAsString();

        Assert.assertEquals(getExpectedResult(), jsonResponse);

    }

    private String getExpectedResult() {
        return "[{\"productId\":1,\"productName\":\"Orange Savings Account\",\"productGroup\":\"Savings\"},{\"productId\":2,\"productName\":\"Savings Deposit\",\"productGroup\":\"Savings\"},{\"productId\":3,\"productName\":\"Bonus Interest Account\",\"productGroup\":\"Savings\"},{\"productId\":4,\"productName\":\"Interest only\",\"productGroup\":\"Mortgage\"}]";
    }
}