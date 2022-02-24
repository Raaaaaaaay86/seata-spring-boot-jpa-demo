package com.example.seatastockservice.service;

public interface StockService {
    void deduct(String commodityCode, int count);
}
