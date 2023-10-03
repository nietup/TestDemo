package com.example.testdemo.controller;

import com.example.testdemo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
public class DemoControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService;

    @Test
    void whenIncomeIsFirstCategoryThenTaxShouldBeFirstLevel() throws Exception {
        final var income = new BigDecimal("50");
        final var expectedTax = new BigDecimal("5.0");
        when(demoService.calculateTax(any())).thenReturn(new BigDecimal("5.0"));

        mockMvc.perform(get("/calc/" + income))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedTax.toString())));
    }
}
