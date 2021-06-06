package com.example.cryptocurrencyportfolio.controllers;

import com.example.cryptocurrencyportfolio.models.Portfolio;
import com.example.cryptocurrencyportfolio.repositories.PortfolioRepository;
import com.example.cryptocurrencyportfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "https://cryptocurrency-portfolio-web.herokuapp.com/")
@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<String> createNewEntry(@RequestBody Portfolio portfolio) throws IOException {
        portfolioService.addNewEntry(portfolio);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Portfolio> getAllEntries() throws Exception {
        return portfolioService.getAllPortfolio();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateEntry(@RequestBody Portfolio portfolio) throws IOException {
        portfolioService.updateEntry(portfolio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) throws Exception {
        portfolioService.deleteEntry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Portfolio> findEntryById(@PathVariable("id") Long id) throws Exception {
        return portfolioService.findPortfolioById(id);
    }


}
