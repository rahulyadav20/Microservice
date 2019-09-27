package com.mettalica.rabbitmq;

import com.mettalica.client.TradeServiceClient;
import com.mettalica.client.model.UpdateTradeRequest;
import com.mettalica.constants.AppConstant;
import com.mettalica.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class Subscriber {

    @Autowired
    TradeServiceClient tradeServiceClient;

    @RabbitListener(queues = "${rabbitmq.queue-name}")
    public void receivedMessage(Trade trade) throws InterruptedException {
        log.info("Received trade is: {}", trade);
        trade.setTradeStatus(AppConstant.TRADE_STATUS_PROCESSED);
        UpdateTradeRequest req = new UpdateTradeRequest();
        req.setTrade(trade);
        TimeUnit.SECONDS.sleep(5);
        tradeServiceClient.updateTrade(req);
    }
}