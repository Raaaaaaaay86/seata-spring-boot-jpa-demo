package com.example.seataaccountservice.service.impl;

import com.example.seataaccountservice.entity.Account;
import com.example.seataaccountservice.repository.AccountDAO;
import com.example.seataaccountservice.service.AccountService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
;        Account account = accountDAO.findByUserId(userId);
         account.setMoney(account.getMoney().subtract(num));
         accountDAO.save(account);

         if (ERROR_USER_ID.equals(userId)) {
             throw new RuntimeException("account branch exception");
         }
    }
}
