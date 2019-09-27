package com.metallica.client.model.response;

import com.metallica.model.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetMarketDataResponse extends BaseResponse {

    String commodityCode;
    BigDecimal price;
}
