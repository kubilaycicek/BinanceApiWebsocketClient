package com.kubilaycicek.BinanceApiWebSocketClient.service;

import com.kubilaycicek.BinanceApiWebSocketClient.dto.Ticker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceRestSyncClient {
    @Value("${binance.rest.http.url}")
    private String url;

    @Scheduled(fixedRate = 3_000)
    public void callTickerPriceService() {
        var restTemplate = new RestTemplate();
        var ticker = restTemplate.getForEntity(url, Ticker.class).getBody();
        System.err.println(Thread.currentThread().getName() + " :" + ticker);
    }

    @Scheduled(fixedRate = 3_000)
    public void asyncCallTickerPriceService() {
        var asyncRestTemplate = new AsyncRestTemplate();

        asyncRestTemplate.getForEntity(url, Ticker.class)
                .addCallback(
                        responseEntity -> System.err.println(Thread.currentThread().getName() + " :" + responseEntity.getBody()),
                        error -> System.err.println(error.getMessage())
                );
    }
}
