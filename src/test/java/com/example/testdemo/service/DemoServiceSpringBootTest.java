package com.example.testdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Here the whole Spring context will be started
// This makes the tests run slower,
// but nicely enough, application context is cached between tests
@SpringBootTest
public class DemoServiceSpringBootTest {

    @Autowired
    private DemoService demoService;

    @Test
    void whenIncomeIsFirstCategoryThenTaxShouldBeFirstLevel() {
        final var income = new BigDecimal("50");
        final var expectedTax = new BigDecimal("5.0");

        final var actualTax = demoService.calculateTax(income);

        assertEquals(expectedTax, actualTax);
    }
}
