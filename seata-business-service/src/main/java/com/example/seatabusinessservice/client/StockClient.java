package com.example.seatabusinessservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockClient {
    @Autowired
    private RestTemplate restTemplate;

    public void deduct(String commodityCode, int orderCount) {
        String url = "http://127.0.0.1:8081/api/stock/deduct?commodityCode=" + commodityCode + "&count=" + orderCount;

        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception exception) {
            throw new RuntimeException(String.format("deduct url %s, error:", url));
        }
    }

}
