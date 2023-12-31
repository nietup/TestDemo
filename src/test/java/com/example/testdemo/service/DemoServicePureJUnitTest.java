package com.example.testdemo.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

// Here the Spring context will not be started,
// thus the tests will run faster
// but this is a very simple example which assumes that there are no dependencies on DemoService
class DemoServicePureJUnitTest {

    @Test
    void whenIncomeIsFirstCategoryThenTaxShouldBeFirstLevel() {
        final var demoService = new DemoService();
        final var income = new BigDecimal("50");
        final var expectedTax = new BigDecimal("5.0");

        final var actualTax = demoService.calculateTax(income);

        assertEquals(expectedTax, actualTax);
    }
}