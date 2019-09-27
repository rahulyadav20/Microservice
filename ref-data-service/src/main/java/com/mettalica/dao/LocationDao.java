package com.mettalica.dao;

import com.mettalica.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends CrudRepository<Location, Integer> {
}
