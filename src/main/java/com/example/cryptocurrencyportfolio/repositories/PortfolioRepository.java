package com.example.cryptocurrencyportfolio.repositories;

import com.example.cryptocurrencyportfolio.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
