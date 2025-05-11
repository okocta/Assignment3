package com.example.assignment3;

import org.springframework.stereotype.Service;

@Service
public class CommandHandler {
    private EventStore events;
    public CommandHandler(EventStore events) {
        this.events = events;
    }
    private  int orderIdCounter = 1;

    public void placeOrder(String userId, String type, double amount, double price) {
        int orderId = orderIdCounter++;
        OrderPlaced orderPlaced = new OrderPlaced(orderId, userId, price, amount,type );
        events.appendEvent(orderPlaced);
    }
    public void cancelOrder(int orderId) {
        OrderCanceled canceled = new OrderCanceled(orderId);
        events.appendEvent(canceled);
    }
    public void executeTrade(int buyOrderId, int sellOrderId, double price, double amount) {
        TradeExecuted executed = new TradeExecuted(price, amount, sellOrderId, buyOrderId);
        events.appendEvent(executed);
    }
    public void debitFunds(String userId, double amount) {
        FundsDebited debited = new FundsDebited(userId, amount);
        events.appendEvent(debited);
    }

    public void creditFunds(String userId, double amount) {
        FundsCredited credited = new FundsCredited(userId, amount);
        events.appendEvent(credited);
    }

}
