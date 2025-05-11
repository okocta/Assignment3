package com.example.assignment3;

import java.time.LocalDateTime;

public class TradeExecuted extends Events{
    private LocalDateTime timeAt;
    private double price;
    private double quantity;
    private int sellID;
    private int buyID;

    public TradeExecuted(){}
    public TradeExecuted(double price, double quantity, int sellID, int buyID) {
        this.price = price;
        this.quantity = quantity;
        this.sellID = sellID;
        this.buyID = buyID;
        this.timeAt = LocalDateTime.now();
    }
    public LocalDateTime getTimeAt() {
        return timeAt;
    }
    public void setTimeAt(LocalDateTime timeAt) {
        this.timeAt = timeAt;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public int getSellID() {
        return sellID;
    }
    public void setSellID(int sellID) {
        this.sellID = sellID;
    }
    public int getBuyID() {
        return buyID;
    }
    public void setBuyID(int buyID) {
        this.buyID = buyID;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }
}
