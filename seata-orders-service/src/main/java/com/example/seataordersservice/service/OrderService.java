package com.example.seataordersservice.service;

public interface OrderService {
    void create(String userId, String commodityCode, Integer count);
}
