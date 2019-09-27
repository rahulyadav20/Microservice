package com.metallica.client;

import com.metallica.client.model.response.GetMarketDataResponse;
import com.metallica.constants.AppConstant;
import com.metallica.model.response.ServiceResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = AppConstant.APP_NAME_ZUUL_API_GATEWAY)
@RibbonClient(name= AppConstant.APP_NAME_MARKET_DATA_SERVICE)
public interface MarketDataServiceClient {

    @GetMapping("/"+ AppConstant.APP_NAME_MARKET_DATA_SERVICE +"/v1/market/{commodityCode}")
    ServiceResponse<GetMarketDataResponse> getMarketPrice(@PathVariable("commodityCode") String commodityCode);
}
