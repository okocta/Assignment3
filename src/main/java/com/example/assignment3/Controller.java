package com.example.assignment3;

import jdk.jfr.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orderbook")
public class Controller {

    private OrderBook orderBook;
    private EventStore eventStore;
    private CommandHandler commandHandler;

    public Controller(OrderBook orderBook, EventStore eventStore,CommandHandler commandHandler) {
        this.orderBook = orderBook;
        this.eventStore = eventStore;
        this.commandHandler= commandHandler;
    }

    @GetMapping("/place")
    public String placeOrder(@RequestParam String placedBY,@RequestParam String otype, @RequestParam double amount,@RequestParam double price) {
        commandHandler.placeOrder(placedBY, otype, amount, price);
        return "OK";
    }
    @GetMapping("/cancel")
    public String cancelOrder(@RequestParam int orderId) {
        commandHandler.cancelOrder(orderId);
        return "OK";
    }
    @GetMapping("/trade")
    public String trade(@RequestParam int buyId,
                        @RequestParam int sellId,
                        @RequestParam double price,
                        @RequestParam double amount) {
        commandHandler.executeTrade(buyId, sellId, price, amount);
        return "OK";
    }

    @GetMapping("/debit")
    public String debit(@RequestParam String userId,
                        @RequestParam double amount) {
        commandHandler.debitFunds(userId, amount);
        return "OK";
    }

    @GetMapping("/credit")
    public String credit(@RequestParam String userId,
                         @RequestParam double amount) {
        commandHandler.creditFunds(userId, amount);
        return "OK";
    }
    @GetMapping("/replay")
    public String replay() {
        orderBook.replay(eventStore.getEvents());
        return "OK";
    }
    @GetMapping("/active")
    public List<OrderPlaced> active() {
        return orderBook.getOrder();
    }
    @GetMapping("/events")
    public List<Events> getEvents() {
        return eventStore.getEvents();
    }
}
