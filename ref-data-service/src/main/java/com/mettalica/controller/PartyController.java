package com.mettalica.controller;

import com.mettalica.dao.PartyDao;
import com.mettalica.model.Party;
import com.mettalica.model.response.GetAllPartiesResponse;
import com.mettalica.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/parties")
public class PartyController {

    @Autowired
    PartyDao partyDao;

    @GetMapping()
    public ServiceResponse<GetAllPartiesResponse> getAllParties(){

        GetAllPartiesResponse response = new GetAllPartiesResponse();
        List<Party> partyList = (List<Party>) partyDao.findAll();
        response.setParties(partyList);
        ServiceResponse<GetAllPartiesResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }
}
