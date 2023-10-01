package com.example.testdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {

    @Test
    void whenIncomeIsFirstCategoryThenTaxShouldBeFirstLevel() {
        final var demoService = new DemoService();
        final var income = new BigDecimal("50");
        final var expectedTax = new BigDecimal("5");

        final var actualTax = demoService.calculateTax(income);

        assertTrue(expectedTax.equals(actualTax));
    }
}