package com.example.cryptocurrencyportfolio.services.implementations;

import com.example.cryptocurrencyportfolio.models.Portfolio;
import com.example.cryptocurrencyportfolio.repositories.PortfolioRepository;
import com.example.cryptocurrencyportfolio.services.ApiService;
import com.example.cryptocurrencyportfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public void addNewEntry(Portfolio portfolio) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        portfolio.setDateOfPurchase(formatter.format(date));

        ApiService apiService = new ApiService();
        portfolio.setEuroValue(BigDecimal.valueOf(portfolio.getAmount() * apiService.convertToEur(portfolio.getCurrency())));

        ApiService apiService1 = new ApiService();
        portfolio.setCurrentEuroValue(BigDecimal.valueOf(portfolio.getAmount() * apiService1.convertToEur(portfolio.getCurrency())));

        portfolio.setProfit_lost_EuroValue(portfolio.getCurrentEuroValue().subtract(portfolio.getEuroValue()));

        portfolioRepository.save(portfolio);
    }

    @Override
    public Optional<Portfolio> findPortfolioById(Long id) throws Exception {
        updateAllCurrentValue();
        return portfolioRepository.findById(id);
    }

    @Override
    public void deleteEntry(Long id) throws Exception {
        findPortfolioById(id).ifPresent(portfolio -> portfolioRepository.deleteById(id));
    }

    @Override
    public void updateEntry(Portfolio portfolio) throws IOException {
        ApiService apiService = new ApiService();
        BigDecimal bigDecimal = BigDecimal.valueOf(portfolio.getAmount() * apiService.convertToEur(portfolio.getCurrency()));
        portfolio.setEuroValue(bigDecimal);

        ApiService apiService1 = new ApiService();
        portfolio.setCurrentEuroValue(BigDecimal.valueOf(portfolio.getAmount() * apiService1.convertToEur(portfolio.getCurrency())));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        portfolio.setDateOfPurchase(formatter.format(date));
        portfolio.setProfit_lost_EuroValue(portfolio.getCurrentEuroValue().subtract(portfolio.getEuroValue()));
        portfolioRepository.saveAndFlush(portfolio);

    }

    @Override
    public List<Portfolio> getAllPortfolio() throws Exception {
        updateAllCurrentValue();
        return portfolioRepository.findAll();
    }

    public void updateAllCurrentValue() throws Exception {
        ApiService apiService = new ApiService();

        for (Portfolio portfolio : portfolioRepository.findAll()) {
            BigDecimal value = BigDecimal.valueOf(portfolio.getAmount() * apiService.convertToEur(portfolio.getCurrency()));
            portfolio.setCurrentEuroValue(value);
            portfolio.setProfit_lost_EuroValue(portfolio.getCurrentEuroValue().subtract(portfolio.getEuroValue()));
            portfolioRepository.saveAndFlush(portfolio);
        }
    }

}
