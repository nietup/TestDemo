package com.example.testdemo.controller;

import com.example.testdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(final DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/calc/{income}")
    @ResponseBody
    public BigDecimal calculateTax(@PathVariable final String income) {
        return demoService.calculateTax(new BigDecimal(income));
    }
}
