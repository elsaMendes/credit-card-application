package com.example.creditcardapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("creditCardController")
public class CreditCardController {

    @GetMapping("/creditcard/getAll")
    public String getAll() {
        return "get All";
    }

    @PostMapping("/creditcard/addNew")
    public String addNew() {
        return "add New";
    }
}
