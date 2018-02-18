package com.avalanche.hotel.Http;

import com.avalanche.hotel.Entities.MoneyEntity;
import com.avalanche.hotel.Exceptions.HttpRequestException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;

public class ExchangeCurrency {
    public static MoneyEntity exchange(MoneyEntity moneyEntity, Currency to) {
        Currency currency = moneyEntity.getCurrency();
        float amount = moneyEntity.getAmount();

        JsonNode response;

        try {
            String jsonResponse = HttpRequest(currency, to);
            response = JSONDecode(jsonResponse);
        } catch (Exception e) {
            throw new HttpRequestException(e.getMessage());
        }

        float exchangeRate = response.path("rates").path(to.getCurrencyCode()).floatValue();
        return new MoneyEntity(to, amount * exchangeRate);
    }

    private static String HttpRequest(Currency from, Currency to) throws Exception {
        String baseURL = "https://api.fixer.io/latest?";
        String requestURL = baseURL + "base=" + from.getCurrencyCode() + "&symbols=" + to.getCurrencyCode();

        URL url = new URL(requestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader buffer = new BufferedReader(reader);
        StringBuffer response = new StringBuffer();

        String inputLine;

        while ((inputLine = buffer.readLine()) != null) {
            response.append(inputLine);
        }

        return response.toString();
    }

    private static JsonNode JSONDecode(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);
    }
}
