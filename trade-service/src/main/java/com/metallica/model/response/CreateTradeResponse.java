package com.metallica.model.response;

import lombok.Data;

@Data
public class CreateTradeResponse extends BaseResponse {

    private Long tradeId;
    private String link;

}
