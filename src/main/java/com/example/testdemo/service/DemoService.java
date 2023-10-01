package com.example.testdemo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DemoService {

    private static final BigDecimal FIRST_LIMIT = new BigDecimal("100");
    private static final BigDecimal SECOND_LIMIT = new BigDecimal("1000");
    private static final BigDecimal FIRST_LEVEL_TAX = new BigDecimal("0.1");
    private static final BigDecimal SECOND_LEVEL_TAX = new BigDecimal("0.2");
    private static final BigDecimal THIRD_LEVEL_TAX = new BigDecimal("0.3");

    public BigDecimal calculateTax(final BigDecimal income) {
        if (income.compareTo(FIRST_LIMIT) < 0) {
            return income.multiply(FIRST_LEVEL_TAX);
        } else if (income.compareTo(SECOND_LIMIT) < 0) {
            return income.multiply(SECOND_LEVEL_TAX);
        } else {
            return income.multiply(THIRD_LEVEL_TAX);
        }
    }
}
