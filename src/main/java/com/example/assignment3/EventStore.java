package com.example.assignment3;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventStore {
    private final List<Events> events = new ArrayList<>();
    public void appendEvent(Events event) {
            events.add(event);
    }
    public ArrayList<Events> getEvents() {
        return new ArrayList<>(events);
    }
}
