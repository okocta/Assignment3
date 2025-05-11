package com.example.assignment3;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OrderPlaced.class, name = "OrderPlaced"),
        @JsonSubTypes.Type(value = OrderCanceled.class, name = "OrderCanceled"),
        @JsonSubTypes.Type(value = TradeExecuted.class, name = "TradeExecuted"),
        @JsonSubTypes.Type(value = FundsCredited.class, name = "FundsCredited"),
        @JsonSubTypes.Type(value = FundsDebited.class, name = "FundsDebited")
})
public abstract class Events {
    public abstract  LocalDateTime getDate();
}
