package com.example.seataordersservice.service.impl;

import com.example.seataordersservice.client.AccountClient;
import com.example.seataordersservice.entity.Order;
import com.example.seataordersservice.repository.OrderDAO;
import com.example.seataordersservice.service.OrderService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void create(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);

        accountClient.debit(userId, orderMoney);
    }
}
