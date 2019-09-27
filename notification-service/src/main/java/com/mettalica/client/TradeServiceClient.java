package com.mettalica.client;

import com.mettalica.client.model.ServiceResponse;
import com.mettalica.client.model.UpdateTradeRequest;
import com.mettalica.client.model.UpdateTradeResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="my-zuul-api-gateway")
@RibbonClient(name="trade-service")
public interface TradeServiceClient {

    @PostMapping("/trade-service/v1/trades/update")
    ServiceResponse<UpdateTradeResponse> updateTrade(@RequestBody UpdateTradeRequest request);
}
