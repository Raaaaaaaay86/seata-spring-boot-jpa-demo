package com.example.seatastockservice.controller;

import com.example.seatastockservice.service.StockService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/stock")
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    Logger logger = LoggerFactory.getLogger(StockController.class);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @GetMapping(path = "/deduct")
    public boolean deduct(String commodityCode, Integer count) {
        logger.info(
            ANSI_GREEN +
            "[OrderService] Got XID ("+ RootContext.getXID() +") from @GlobalTransactional way down" +
            ANSI_RESET
        );
        stockService.deduct(commodityCode, count);
        return true;
    }
}
