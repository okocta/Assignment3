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
    public String placeOrder(@RequestParam String placedBY,@RequestParam String type, @RequestParam double amount,@RequestParam double price) {
        commandHandler.placeOrder(placedBY, type, amount, price);
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
