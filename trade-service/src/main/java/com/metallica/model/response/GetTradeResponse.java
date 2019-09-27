package com.metallica.model.response;

import com.metallica.model.entity.Trade;
import lombok.Data;

@Data
public class GetTradeResponse extends BaseResponse {

    Trade trade;
}
