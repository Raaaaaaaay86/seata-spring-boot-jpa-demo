package com.example.seatastockservice.controller;

import com.example.seatastockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/stock")
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping(path = "/deduct")
    public boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }
}