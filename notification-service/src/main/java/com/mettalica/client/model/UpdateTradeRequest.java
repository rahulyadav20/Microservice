package com.mettalica.client.model;

import com.mettalica.model.Trade;
import lombok.Data;

@Data
public class UpdateTradeRequest extends BaseRequest {

    Trade trade;
}
