package com.example.seataordersservice.controller;

import com.example.seataordersservice.service.OrderService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @GetMapping(value = "/debit")
    public void debit(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam Integer count) {
        logger.info(
            ANSI_GREEN +
            "[OrderService] Got XID ("+ RootContext.getXID() +") from @GlobalTransactional way down" +
            ANSI_RESET
        );
        orderService.create(userId, commodityCode, count);
    }
}
