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
public class TestTariffs {


    @Autowired
    private Flyway flyway;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        flyway.migrate();
    }

    @Test
    void getAllPriceListOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/tariff-controller/tariffs")
                        .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                        .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }


    void getPriceListByIdOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/tariff-controller/tariff/1")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }


    @Test
    void getPriceListError404() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/tariff-controller/tariff-query")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.NOT_FOUND.value())));
    }



}



