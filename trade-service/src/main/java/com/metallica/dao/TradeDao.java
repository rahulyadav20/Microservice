package com.metallica.dao;

import com.metallica.model.entity.Trade;
import org.springframework.data.repository.CrudRepository;

public interface TradeDao extends CrudRepository<Trade, Long> {

    int countById(Long id);
}
