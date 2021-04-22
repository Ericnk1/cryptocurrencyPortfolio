package com.example.cryptocurrencyportfolio.services.implementations;

import com.example.cryptocurrencyportfolio.models.Portfolio;
import com.example.cryptocurrencyportfolio.repositories.PortfolioRepository;
import com.example.cryptocurrencyportfolio.services.ApiService;
import com.example.cryptocurrencyportfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public void addNewEntry(Portfolio portfolio) throws IOException {
        ApiService apiService = new ApiService();
        portfolio.setValueEuro(BigDecimal.valueOf(portfolio.getAmount() * apiService.convertToEur(portfolio.getCurrency())));
        portfolio.setDateOfPurchase(java.time.LocalDateTime.now());
    }

    @Override
    public Optional<Portfolio> findPortfolioById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteEntry(Long id) {
        portfolioRepository.deleteById(id);
    }

    @Override
    public void updateEntry(Portfolio portfolio) throws IOException {
        ApiService apiService = new ApiService();

        BigDecimal bigDecimal = BigDecimal.valueOf(portfolio.getAmount() * apiService.convertToEur(portfolio.getCurrency()));
        portfolio.setValueEuro(bigDecimal);
        portfolio.setDateOfPurchase(java.time.LocalDateTime.now());
        portfolioRepository.saveAndFlush(portfolio);

    }

    @Override
    public List<Portfolio> getAllPortfolio() {
        return portfolioRepository.findAll();
    }
}
