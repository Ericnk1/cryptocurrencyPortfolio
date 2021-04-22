CREATE SEQUENCE IF NOT EXISTS portfolio;

CREATE TABLE IF NOT EXISTS portfolio(

    Id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Currency VARCHAR(150) NOT NULL,
    Amount VARCHAR(150) NOT NULL,
    Date_Of_Purchase VARCHAR (150) NOT NULL,
    Wallet_Location VARCHAR(150) NOT NULL,
    Value_Euro DECIMAL

    );