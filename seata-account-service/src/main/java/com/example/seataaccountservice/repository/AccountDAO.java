package com.example.seataaccountservice.repository;

import com.example.seataaccountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Long> {
    Account findByUserId(String userId);
}
