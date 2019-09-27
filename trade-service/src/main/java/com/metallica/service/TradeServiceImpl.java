package com.metallica.service;

import com.metallica.client.MarketDataServiceClient;
import com.metallica.client.model.response.GetMarketDataResponse;
import com.metallica.constants.AppConstant;
import com.metallica.dao.TradeDao;
import com.metallica.exception.ServiceException;
import com.metallica.exception.TradeNotFoundException;
import com.metallica.model.entity.Trade;
import com.metallica.model.response.ServiceResponse;
import com.metallica.rabbitmq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class TradeServiceImpl implements ITradeService {

    @Autowired
    TradeDao tradeDao;

    @Autowired
    MarketDataServiceClient mdClient;

    @Autowired
    MessageSender publisher;

    @Override
    public Trade createTrade(Trade trade) {
        if (tradeDao.countById(trade.getId()) > 0) {
            throw new ServiceException("ER-1002", "Trade already exists!");
        }
        if (trade.getPrice() == null) {
            ServiceResponse<GetMarketDataResponse> mdResponse = mdClient.getMarketPrice(trade.getCommodity());
            GetMarketDataResponse response = mdResponse.getResponse();
            if (null == response) {
                throw new ServiceException("ER-5001", "Error from mdClient: " + mdResponse.getException().getMessage());
            }
            trade.setPrice(response.getPrice());
        }
        trade.setTradeDate(new Date());
        trade.setCounterParty("Amazon");
        trade.setLocation("London");
        trade.setTradeStatus(AppConstant.INITIATED);
        tradeDao.save(trade);
        publisher.produceMsg(trade);
        return trade;
    }

    @Override
    public Trade getTrade(Long tradeId) {
        Optional<Trade> trade = tradeDao.findById(tradeId);
        if (!trade.isPresent()) {
            throw new TradeNotFoundException("ER-1001", "Trade not found!");
        }
        return trade.get();
    }

    @Override
    public void updateTrade(Trade trade) {
        if (tradeDao.countById(trade.getId()) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        tradeDao.save(trade);
    }

    @Override
    public void deleteById(Long tradeId) {
        if (tradeDao.countById(tradeId) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        tradeDao.deleteById(tradeId);
    }
}
