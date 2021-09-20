package com.kubilaycicek.BinanceApiWebSocketClient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kubilaycicek.BinanceApiWebSocketClient.dto.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;


@Service
public class BinanceWebSocketClient implements WebSocketHandler {

    @Value("${binance.websocket.url}")
    private String url;

    @Autowired
    private WebSocketClient webSocketClient;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        webSocketClient.doHandshake(this, url);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.err.println("Connected to the websocket server!");
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        var trade = objectMapper.readValue(webSocketMessage.getPayload().toString(), Trade.class);
        System.err.println(trade);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.err.println("Error has occurred: " + throwable.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.err.println("Disconnect from websocket server!");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
