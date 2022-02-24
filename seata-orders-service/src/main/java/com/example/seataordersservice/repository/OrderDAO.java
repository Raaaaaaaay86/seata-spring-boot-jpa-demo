package com.example.seataordersservice.repository;

import com.example.seataordersservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
