package ru.zewius.currencyconverter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Map;
import java.util.TreeMap;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "ru.zewius.currencyconverter")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean(name = "viewResolver")
    @Description("View Resolver to handle JSP")
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/pages/");
        bean.setSuffix(".jsp");

        return bean;
    }

    @Bean(name = "currencies")
    @Description("List of popular world currencies")
    public Map<String, String> getCurrencies() {
        Map<String, String> currencies = new TreeMap<>();
        currencies.put("RUB", "Российский рубль");
        currencies.put("USD", "Доллар США");
        currencies.put("EUR", "Евро");
        currencies.put("JPY", "Японская иена");
        currencies.put("GPB", "Фунт стерлингов");
        currencies.put("AUD", "Австралийский доллар");
        currencies.put("CAD", "Канадский доллар");
        currencies.put("CHF", "Швейцарский франк");
        currencies.put("CNY", "Китайский юань");
        currencies.put("SEK", "Шведская крона");
        currencies.put("MXN", "Мексиканский песо");
        currencies.put("NZD", "Новозеландский доллар");
        currencies.put("SGD", "Сингапурский доллар");
        currencies.put("HKD", "Гонконгский доллар");

        return currencies;
    }
}