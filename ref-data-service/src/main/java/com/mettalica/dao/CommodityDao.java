package com.mettalica.dao;

import com.mettalica.model.Commodity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends CrudRepository<Commodity, Integer> {
}
