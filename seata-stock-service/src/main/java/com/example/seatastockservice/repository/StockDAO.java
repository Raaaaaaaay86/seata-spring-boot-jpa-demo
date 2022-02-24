package com.example.seatastockservice.repository;

import com.example.seatastockservice.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDAO extends JpaRepository<Stock, Long> {
    Stock findByCommodityCode(String commodityCode);
}
