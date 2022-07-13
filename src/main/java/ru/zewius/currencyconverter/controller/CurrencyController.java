package ru.zewius.currencyconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.zewius.currencyconverter.service.CurrencyService;

import java.util.Map;

@Controller
@RequestMapping("/")
public class CurrencyController {

    private final Map<String, String> currencies;
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(Map<String, String> currencies, CurrencyService currencyService) {
        this.currencies = currencies;
        this.currencyService = currencyService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("currencies", currencies);

        return "currency-start";
    }

    @PostMapping
    public String post(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("value") String valueFrom,
            Model model) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);

        double valueFromDouble;
        try {
            valueFromDouble = Double.parseDouble(valueFrom);

            if (valueFromDouble <= 0.0) {
                valueFromDouble = 1.0;
            }
        } catch (Exception ex) {
            valueFromDouble = 1.0;
        }

        model.addAttribute("valueFrom", String.valueOf(valueFromDouble));

        double valueTo = currencyService.getNominal(from, to) * valueFromDouble;
        model.addAttribute("valueTo", valueTo);

        return "currency-result";
    }
}
