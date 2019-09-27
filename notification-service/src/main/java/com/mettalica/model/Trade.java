package com.mettalica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Trade implements Serializable {

    Long id;
    String side;
    BigDecimal price;
    BigDecimal quantity;
    String commodity;
    String counterParty;
    String location;
    Date tradeDate;
    String tradeStatus;
}
