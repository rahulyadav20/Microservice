package com.mettalica.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetMarketDataResponse extends BaseResponse {

    String commodityCode;
    BigDecimal price;
}
