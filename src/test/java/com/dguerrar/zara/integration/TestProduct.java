package com.dguerrar.zara.integration;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class TestProduct {


    @Autowired
    private Flyway flyway;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        flyway.migrate();
    }

    @Test
    void getAllProductsOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/product-controller/products")
                        .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                        .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }


    void getProductByIdOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/product-controller/product/1")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }


    @Test
    void getProductsError404() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/product-controller/product-query")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.NOT_FOUND.value())));
    }



}



