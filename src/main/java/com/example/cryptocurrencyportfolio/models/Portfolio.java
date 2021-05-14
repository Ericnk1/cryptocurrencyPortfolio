package com.example.cryptocurrencyportfolio.models;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotBlank(message = "Currency is required")
    public String currency;

    @Positive(message = "Only positive number accepted")
    private double amount;

    private String dateOfPurchase;

    @NotBlank(message = "Wallet location is required")
    private String walletLocation;

    private BigDecimal euroValue;

    private BigDecimal currentEuroValue;

    private BigDecimal profitLostEuroValue;
}
