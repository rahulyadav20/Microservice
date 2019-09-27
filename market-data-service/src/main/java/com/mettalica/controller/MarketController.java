package com.mettalica.controller;

import com.mettalica.dao.MarketDataDao;
import com.mettalica.exception.ServiceException;
import com.mettalica.model.MarketData;
import com.mettalica.model.response.GetMarketDataResponse;
import com.mettalica.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/market")
public class MarketController {

    @Autowired
    MarketDataDao dao;

    @GetMapping("/{commodityCode}")
    public ServiceResponse<GetMarketDataResponse> getMarketPrice(@PathVariable String commodityCode){

        GetMarketDataResponse response = new GetMarketDataResponse();
        MarketData data = dao.findByCommodity(commodityCode);
        if(null == data){
            throw new ServiceException("ER-1001", "Commodity/Pricing not available!");
        }
        response.setCommodityCode(data.getCommodity());
        response.setPrice(data.getPrice());
        ServiceResponse<GetMarketDataResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }
}
