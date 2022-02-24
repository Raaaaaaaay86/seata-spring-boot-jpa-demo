package com.example.seatastockservice.service.impl;

import com.example.seatastockservice.entity.Stock;
import com.example.seatastockservice.repository.StockDAO;
import com.example.seatastockservice.service.StockService;
import io.seata.core.context.RootContext;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDAO stockDAO;

    @Override
    @Transactional
    public void deduct(String commodityCode, int count) {
        Stock stock = stockDAO.findByCommodityCode(commodityCode);
        stock.setCount(stock.getCount() - count);

        stockDAO.save(stock);
    }
}
