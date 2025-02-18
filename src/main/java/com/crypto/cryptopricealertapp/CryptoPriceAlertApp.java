package com.crypto.cryptopricealertapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

@SpringBootApplication
public class CryptoPriceAlertApp {

    public static void main(String[] args) {
        SpringApplication.run(CryptoPriceAlertApp.class, args);
        startWebSocketClient();
    }

    private static void startWebSocketClient() {
        StandardWebSocketClient client = new StandardWebSocketClient();
        String binanceEndpoint = "wss://stream.binance.com:9443/ws/btcusdt@trade";

        client.doHandshake(new TextWebSocketHandler() {
            @Override
            public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                System.out.println("Received: " + message.getPayload());
            }
        }, binanceEndpoint);
    }

}
