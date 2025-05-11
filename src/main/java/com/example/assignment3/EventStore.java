package com.example.assignment3;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventStore {
    private final OrderBook orderBook;
    private List<Events> events = new ArrayList<>();
    private final String filename="events.json";

    public EventStore(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void appendEvent(Events event) {
            events.add(event);
            saveEventsToFile();
    }
    public ArrayList<Events> getEvents() {
        return new ArrayList<>(events);
    }


    @PostConstruct
    public void loadEventsFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File file = new File("events.json");
            if (file.exists()) {
                Events[] loaded = mapper.readValue(file, Events[].class);
                events = new ArrayList<>(List.of(loaded));
                orderBook.replay(events);
            }
        } catch (Exception e) {
            System.err.println("Failed to load events: " + e.getMessage());
        }
    }
    private void saveEventsToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.writerFor(new TypeReference<List<Events>>() {})
                    .withDefaultPrettyPrinter()
                    .writeValue(new File("events.json"), events);

        } catch (Exception e) {
            System.err.println("Failed to save events: " + e.getMessage());
        }
    }



}
