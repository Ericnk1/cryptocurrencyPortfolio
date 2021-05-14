package com.example.cryptocurrencyportfolio.controllers;


import com.example.cryptocurrencyportfolio.models.Currency;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping
    public List<Currency> getCurrencyLists() {return Arrays.asList(Currency.values());
    }
}
