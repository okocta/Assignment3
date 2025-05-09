package com.example.assignment3;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderBook {
    private Map<Integer,OrderPlaced> orders=new HashMap<>();
    public void replay(List<Events>events){
        for(Events e:events){
            if(e instanceof OrderPlaced placed){
                orders.put(placed.getOrderId(),placed);
            }else if(e instanceof OrderCanceled canceled){
                orders.remove(canceled.getOrderId());
            }else if(e instanceof TradeExecuted tradeExecuted){
                orders.remove(tradeExecuted.getBuyID());
                orders.remove(tradeExecuted.getSellID());
            }
        }
    }

    public List<OrderPlaced> getOrder(){
        return new ArrayList<>(orders.values());
    }
}
