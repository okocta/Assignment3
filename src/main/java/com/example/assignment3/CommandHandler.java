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

}
