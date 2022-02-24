package com.example.seataaccountservice.controller;

import com.example.seataaccountservice.service.AccountService;
import io.seata.core.context.RootContext;
import java.math.BigDecimal;
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

    @GetMapping(value = "/updateUser")
    public void debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        System.out.println("account XID: " + RootContext.getXID());
        accountService.debit(userId, orderMoney);
    }
}
