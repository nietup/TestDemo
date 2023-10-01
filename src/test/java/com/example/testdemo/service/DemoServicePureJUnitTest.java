package com.example.testdemo.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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