package com.example.cryptocurrencyportfolio.services;

import com.example.cryptocurrencyportfolio.models.Portfolio;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PortfolioService {

    /**
     * To add a new portfolio
     *
     * @param portfolio Portfolio
     */
     void addNewEntry(Portfolio portfolio) throws IOException;

    /**
     * To find portfolio by id
     *
     * @param id Portfolio id
     * @return optional of portfolio
     */
     Optional<Portfolio> findPortfolioById(Long id) throws Exception;

    /**
     * To delete portfolio by id
     *
     * @param id Portfolio id
     */
     void deleteEntry(Long id) throws Exception;

    /**
     * To update an existing portfolio
     *
     * @param portfolio Portfolio
     */
     void updateEntry(Portfolio portfolio) throws IOException;

    /**
     * To get all portfolios
     *
     * @return list of portfolios
     */
     List<Portfolio> getAllPortfolio() throws Exception;


    /**
     * List of portfolios with the updated value
     */
    void updateAllCurrentValue() throws Exception;


    // BigDecimal sumOfAllCurrentValue() throws Exception;


}
