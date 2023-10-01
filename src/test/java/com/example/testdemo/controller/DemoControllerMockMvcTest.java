package com.example.testdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This approach starts the Spring context,
// but it doesn't start the server
@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenIncomeIsFirstCategoryThenTaxShouldBeFirstLevel() throws Exception {
        final var income = new BigDecimal("50");
        final var expectedTax = new BigDecimal("5.0");

        mockMvc.perform(get("/calc/" + income))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedTax.toString())));
    }
}