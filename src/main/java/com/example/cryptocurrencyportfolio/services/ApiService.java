package com.example.cryptocurrencyportfolio.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;

@Service
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
            case "Bitcoin_SV":
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
            case "Bitcoin_Cash":
                currency = "BCH";
                break;
            case "Binance_Coin":
                currency = "BNB";
                break;
            case "Ethereum_Classic":
                currency = "ETC";
                break;
            case "Solana":
                currency = "SOL";
                break;
            case "Filecoin":
                currency = "FIL";
                break;
            case "Wrapped_Bitcoin":
                currency = "WBTC";
                break;
            case "Neo":
                currency = "NEO";
                break;
            case "PancakeSwap":
                currency = "CAKE";
                break;
            case "Aave":
                currency = "AAVE";
                break;
            case "FTX_Token":
                currency = "FTT";
                break;
            case "Maker":
                currency = "MKR";
                break;
            case "Dash":
                currency = "DASH";
                break;
            case "Compound":
                currency = "COMP";
                break;
            case "Kusama":
                currency = "KSM";
                break;
            case "Elrond":
                currency = "EGLD";
                break;
            case "Zcash":
                currency = "ZEC";
                break;
            case "Bitcoin_BEP2":
                currency = "BTCB";
                break;
            case "Decred":
                currency = "DCR";
                break;
            case "Bitcoin Gold":
                currency = "BTG";
                break;
            case "yearn_finance":
                currency = "YFI";
                break;
            case "Horizen":
                currency = "ZEN";
                break;
            case "Venus":
                currency = "XVS";
                break;
            case "renBTC":
                currency = "RENBTC";
                break;
            case "Bitcoin_Standard_Hashrate_Token":
                currency = "BTCST";
                break;
            case "Gnosis":
                currency = "GNO";
                break;
            case "Numeraire":
                currency = "NMR";
                break;
            case "Uquid_Coin":
                currency = "UQC";
                break;
            case "Badger_DAO":
                currency = "BADGER";
                break;
            case "Haven_Protocol":
                currency = "XHV";
                break;
            case "Balancer":
                currency = "BAL";
                break;
            case "Augur":
                currency = "REP";
                break;
            case "Quant":
                currency = "QNT";
                break;
            case "Injective_Protocol":
                currency = "INJ";
                break;
            case "Prometeus":
                currency = "PROM";
                break;
            case "Livepeer":
                currency = "LPT";
                break;
            case "Arweave":
                currency = "AR";
                break;
            case "Flow":
                currency = "FLOW";
                break;
            case "OKB":
                currency = "OKB";
                break;
            case "Waves":
                currency = "WAVES";
                break;
            case "Huobi_Token":
                currency = "HT";
                break;
            case "Cosmos":
                currency = "ATOM";
                break;
            case "Chainlink":
                currency = "LINK";
                break;
            case "Uniswap":
                currency = "UNI";
                break;
            case "Polkadot":
                currency = "DOT";
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
