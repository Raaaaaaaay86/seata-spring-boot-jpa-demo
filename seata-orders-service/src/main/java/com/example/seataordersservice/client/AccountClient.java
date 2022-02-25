package com.example.seataordersservice.client;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${client-service.host.account}")
    private String ACCOUNT_HOST;

    public void debit(String userId, BigDecimal orderMoney) {
        String url = "http://"+ ACCOUNT_HOST +":8083/api/account/updateUser?userId=" + userId + "&orderMoney=" + orderMoney;

        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception exception) {
            throw new RuntimeException(String.format("debit url %s, error:",url), exception);
        }
    }
}
