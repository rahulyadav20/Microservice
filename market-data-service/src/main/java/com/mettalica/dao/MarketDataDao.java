package com.mettalica.dao;

import com.mettalica.model.MarketData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataDao extends CrudRepository<MarketData, Integer> {

    MarketData findByCommodity(String commodity);
}
