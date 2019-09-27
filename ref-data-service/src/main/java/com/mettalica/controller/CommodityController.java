package com.mettalica.controller;

import com.mettalica.dao.CommodityDao;
import com.mettalica.model.Commodity;
import com.mettalica.model.response.GetAllCommoditiesResponse;
import com.mettalica.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/commodities")
public class CommodityController {

    @Autowired
    CommodityDao commodityDao;

    @GetMapping()
    public ServiceResponse<GetAllCommoditiesResponse> getAllCommodities(){

        GetAllCommoditiesResponse response = new GetAllCommoditiesResponse();
        List<Commodity> commList = (List<Commodity>) commodityDao.findAll();
        response.setCommodities(commList);
        ServiceResponse<GetAllCommoditiesResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }
}
