package com.dguerrar.zara.integration;

import com.dguerrar.zara.dto.QueryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class TestPrice {

    @Autowired
    private Flyway flyway;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        flyway.migrate();
    }


    @Test
    void getAllPricesOK() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/price-entry-controller/price-entries")
                .contentType("application/json"));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }



    @Test
    void getAPricesKO1() throws Exception {
        String jsonInString="{";
        ResultActions resultActions = mockMvc.perform(post("/price-entry-controller/price-entry-query")
                .contentType("application/json")
                .content(jsonInString));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.BAD_REQUEST.value())));
    }

    @Test
    void getAPricesKO2() throws Exception {
        String jsonInString="{\"brandI2d\":\"1\",\n" +
                "\"produc2tId\":\"35455\",\n" +
                "\"dat2e\":\"2020/07/15 10:00:00\"\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(post("/price-entry-controller/price-entry-query")
                .contentType("application/json")
                .content(jsonInString));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value())));
    }


    @Test
    void getAPriceOK() throws Exception {

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        QueryDTO dto= new QueryDTO();
        dto.setBrandId(1l);
        dto.setProductId(35455l);
        String str = "2020/07/15 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        dto.setDate(dateTime);

        String jsonInString = mapper.writeValueAsString(dto);
        ResultActions resultActions = mockMvc.perform(post("/price-entry-controller/price-entry-query")
                .contentType("application/json")
                .content(jsonInString));
        MockHttpServletResponse mockResponse = resultActions.andReturn()
                .getResponse();

        assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(String.valueOf(HttpStatus.OK.value())));
    }

}
