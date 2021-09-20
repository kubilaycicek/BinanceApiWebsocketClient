package com.kubilaycicek.BinanceApiWebSocketClient.dto;

// {"symbol":"BTCUSDT","price":"43648.89000000"}
public class Ticker {
    private String symbol;
    private String price;

    private Ticker() {
    }

    public Ticker(String symbol, String price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
