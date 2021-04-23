package com.example.cryptocurrencyportfolio.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;

public class ApiService {

    final static String postEndpoint = "https://api.bitfinex.com/v2/calc/fx";

    public double convertToEur(String currency) throws IOException {


        switch (currency) {
            case "Bitcoin":
                currency = "BTC";
                break;
            case "Ethereum":
                currency = "ETH";
                break;
            case "Ripple":
                currency = "XRP";
                break;
            case "Litecoin":
                currency = "LTC";
                break;
            case "Bitcoin SV":
                currency = "BSV";
                break;
            case "EOS":
                currency = "EOS";
                break;
            case "Stellar":
                currency = "XLM";
                break;
            case "TRON":
                currency = "TRX";
                break;
            case "Monero":
                currency = "XMR";
                break;
            case "Bitcoin Cash":
                currency = "BCH";
                break;
        }

        String inputJson = "{\"ccy1\":\"" + currency + "\",\"ccy2\":\"EUR\"}";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(postEndpoint);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        StringEntity entity = new StringEntity(inputJson);
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        JsonParser jsonParser = new JsonParser();
        JsonElement content = jsonParser.parse(new InputStreamReader((response.getEntity().getContent())));
        return content.getAsDouble();
    }
}
