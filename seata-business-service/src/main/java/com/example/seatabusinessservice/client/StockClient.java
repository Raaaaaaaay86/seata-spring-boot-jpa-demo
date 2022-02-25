package com.example.seatabusinessservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${client-service.host.stock}")
    private String STOCK_HOST;

    public void deduct(String commodityCode, int orderCount) {
        String url = "http://" + STOCK_HOST + ":8081/api/stock/deduct?commodityCode=" + commodityCode + "&count=" + orderCount;

        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception exception) {
            throw new RuntimeException(String.format("deduct url %s, error:", url));
        }
    }

}
