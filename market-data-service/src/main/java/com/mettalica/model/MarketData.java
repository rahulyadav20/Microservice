package com.mettalica.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class MarketData {

    @Id
    @GeneratedValue
    int id;
    String commodity;
    BigDecimal price;
}
