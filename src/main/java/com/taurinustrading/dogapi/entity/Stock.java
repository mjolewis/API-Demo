package com.taurinustrading.dogapi.entity;

public class Stock {
    private String symbol;
    private String sector;
    private String securityType;
    private int bidPrice;
    private int bidSize;
    private int askPrice;
    private int askSize;
    private String lastUpdated;
    private int lastSalePrice;

    public Stock() {
    }

    public Stock(String symbol, String sector, String securityType, int bidPrice, int bidSize, int askPrice, int askSize, String lastUpdated, int lastSalePrice) {
        this.symbol = symbol;
        this.sector = sector;
        this.securityType = securityType;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
        this.lastUpdated = lastUpdated;
        this.lastSalePrice = lastSalePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(int lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }
}
