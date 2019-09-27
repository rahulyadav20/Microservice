package com.metallica.controller;

import com.metallica.model.entity.Trade;
import com.metallica.model.request.CreateTradeRequest;
import com.metallica.model.request.UpdateTradeRequest;
import com.metallica.model.response.*;
import com.metallica.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/trades")
public class TradeController {

    @Autowired
    ITradeService tradeService;

    @PostMapping("/create")
    public ServiceResponse<CreateTradeResponse> createTrade(@Valid @RequestBody CreateTradeRequest request){

        Trade trade = tradeService.createTrade(request.getTrade());
        CreateTradeResponse response = new CreateTradeResponse();
        response.setTradeId(trade.getId());
        response.setLink("/v1/trades/"+trade.getId());
        ServiceResponse<CreateTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }

    @GetMapping("/{tradeId}")
    public ServiceResponse<GetTradeResponse> getTrade(@PathVariable @Min(1) Long tradeId){

        GetTradeResponse response = new GetTradeResponse();
        response.setTrade(tradeService.getTrade(tradeId));
        ServiceResponse<GetTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }

    @PostMapping("/update")
    public ServiceResponse<UpdateTradeResponse> updateTrade(@Valid @RequestBody UpdateTradeRequest request){

        tradeService.updateTrade(request.getTrade());
        UpdateTradeResponse response = new UpdateTradeResponse();
        response.setMessage("Successfully updated!");
        ServiceResponse<UpdateTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }

    @DeleteMapping("/{tradeId}")
    public ServiceResponse<DeleteTradeResponse> deleteTrade(@PathVariable @Min(1) Long tradeId){

        DeleteTradeResponse response = new DeleteTradeResponse();
        tradeService.deleteById(tradeId);
        response.setMessage("Successfully deleted!");
        ServiceResponse<DeleteTradeResponse> res = new ServiceResponse<DeleteTradeResponse>();
        res.setResponse(response);
        return res;
    }

}
