package com.example.cryptocurrencyportfolio.controllers;

import com.example.cryptocurrencyportfolio.models.Wallet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @GetMapping
    public List<Wallet> getWalletLists() {return Arrays.asList(Wallet.values());
    }
}
