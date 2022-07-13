package ru.zewius.currencyconverter.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Map;

@Service
public class CurrencyService {
    private final String apiKey;
    private final RestTemplate restTemplate;
    private final Gson gson;
    private final Type jsonMapType;

    @Autowired
    public CurrencyService(Environment env) {
        this.apiKey = env.getProperty("service.currency_api.key");
        this.restTemplate = new RestTemplate();
        this.gson = new Gson();
        this.jsonMapType = new TypeToken<Map<String, Double>>() {
        }.getType();
    }

    public double getNominal(String from, String to) {
        String url = "https://free.currconv.com/api/v7/convert?q=" +
                from +
                "_" +
                to +
                "&compact=ultra&apiKey=" +
                apiKey;

        Map<String, Double> map = gson.fromJson(restTemplate.getForObject(url, String.class), jsonMapType);
        assert map != null;
        return map.get(from + "_" + to);
    }
}