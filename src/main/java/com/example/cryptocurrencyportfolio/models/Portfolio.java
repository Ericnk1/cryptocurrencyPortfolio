package com.example.cryptocurrencyportfolio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    public Long id;

    public String currency;

    @Positive(message = "Only positive number accepted")
    private double amount;

    private LocalDateTime dateOfPurchase;

    @NotBlank(message = "Wallet location is required")
    private String WalletLocation;

    @Column(updatable = false)
    private BigDecimal valueEuro;
}
