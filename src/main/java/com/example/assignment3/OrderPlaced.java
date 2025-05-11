package com.example.assignment3;


import java.time.LocalDateTime;

public class OrderPlaced extends Events {

    private int orderId;
    private LocalDateTime placedAt;
    private String placedBy;
    private double price;
    private double quantity;
    private String otype;

    public OrderPlaced() {}
    public OrderPlaced(int orderId,String placedBy, double price, double quantity, String otype) {
        this.orderId = orderId;
        this.placedAt = LocalDateTime.now();
        this.placedBy = placedBy;
        this.price = price;
        this.quantity = quantity;
        this.otype = otype;

    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getPlacedAt() {
        return placedAt;
    }
    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }
    public String getPlacedBy() {
        return placedBy;
    }
    public void setPlacedBy(String placedBy) {
        this.placedBy = placedBy;
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getOType() {
        return otype;
    }
    public void setOType(String otype) {
        this.otype = otype;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }
}
