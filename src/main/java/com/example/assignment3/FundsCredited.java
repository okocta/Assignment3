package com.example.assignment3;

import java.time.LocalDateTime;

public class FundsCredited extends Events{
    private String placedBy;
    private double funds;
    private LocalDateTime timeAt;

    public FundsCredited(){}
    public FundsCredited(String placedBy, double funds) {
        this.placedBy = placedBy;
        this.funds = funds;
    }
    public String getPlacedBy() {
        return placedBy;
    }
    public void setPlacedBy(String placedBy) {
        this.placedBy = placedBy;
    }
    public double getFunds() {
        return funds;
    }
    public void setFunds(double funds) {
        this.funds = funds;
    }
    public LocalDateTime getTimeAt() {
        return timeAt;
    }
    public void setTimeAt(LocalDateTime timeAt) {
        this.timeAt = timeAt;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }
}
