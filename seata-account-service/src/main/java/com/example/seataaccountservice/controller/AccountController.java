package com.example.seataaccountservice.controller;

import com.example.seataaccountservice.service.AccountService;
import io.seata.core.context.RootContext;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    Logger logger = LoggerFactory.getLogger(AccountController.class);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @GetMapping(value = "/updateUser")
    public void debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        logger.info(
            ANSI_GREEN +
            "[AccountService] Got XID ("+ RootContext.getXID() +") from @GlobalTransactional way down" +
            ANSI_RESET
        );
        accountService.debit(userId, orderMoney);
    }
}
