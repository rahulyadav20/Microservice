package com.metallica.model.request;

import com.metallica.model.entity.Trade;
import lombok.Data;

@Data
public class UpdateTradeRequest extends BaseRequest{

    Trade trade;
}
