package com.example.seataordersservice.client;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClient {

    @Autowired
    RestTemplate restTemplate;

    public void debit(String userId, BigDecimal orderMoney) {
        String url = "http://127.0.0.1:8083/api/account/updateUser?userId=" + userId + "&orderMoney=" + orderMoney;

        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception exception) {
            throw new RuntimeException(String.format("debit url %s, error:",url), exception);
        }
    }
}
