package com.example.assignment3;

import java.time.LocalDateTime;

public class OrderCanceled implements Events{
    private int orderId;
    private LocalDateTime timeAt;

    public OrderCanceled(int orderId) {
        this.orderId = orderId;
        this.timeAt = LocalDateTime.now();
    }
    public int getOrderId() {
        return orderId;
    }
    public LocalDateTime getTimeAt() {
        return timeAt;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }
}
