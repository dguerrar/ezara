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
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBranch {


    @Autowired
    private Flyway flyway;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        flyway.migrate();
    }

    @Test
    void getAllBrandsOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/brand-controller/brands")
                        .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                        .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }


    @Test
    void getBrandsError404() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/brand-controller/price-entry-query")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.NOT_FOUND.value())));
    }
}
