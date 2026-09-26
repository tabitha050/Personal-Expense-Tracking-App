package com.first.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    @GetMapping("/expense")
    public String expense() {
        return "expense";
    }
}