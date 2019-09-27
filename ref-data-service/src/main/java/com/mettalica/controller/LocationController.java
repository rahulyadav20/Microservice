package com.mettalica.controller;

import com.mettalica.dao.LocationDao;
import com.mettalica.model.Location;
import com.mettalica.model.response.GetAllLocationsResponse;
import com.mettalica.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/locations")
public class LocationController {

    @Autowired
    LocationDao locationDao;

    @GetMapping()
    public ServiceResponse<GetAllLocationsResponse> getAllLocations(){

        GetAllLocationsResponse response = new GetAllLocationsResponse();
        List<Location> locList = (List<Location>) locationDao.findAll();
        response.setLocations(locList);
        ServiceResponse<GetAllLocationsResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }
}
