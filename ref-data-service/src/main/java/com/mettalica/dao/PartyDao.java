package com.mettalica.dao;

import com.mettalica.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyDao extends CrudRepository<Party, Integer> {
}
