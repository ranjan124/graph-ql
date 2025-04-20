package com.shieldteq.graph.part3.service;

import com.shieldteq.graph.part3.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private static final Map<String, List<CustomerOrder>> orders = Map.of(
            "John", List.of(new CustomerOrder("1", "First order"), new CustomerOrder("2", "Second order")),
            "Jane", List.of(new CustomerOrder("3", "Third order"), new CustomerOrder("4", "Fourth order"))
    );

    public Flux<CustomerOrder> getOrders(String customer) {
        return Flux.fromIterable(orders.getOrDefault(customer, List.of()));
    }

    public Flux<CustomerOrder> getOrders(String name, Integer limit) {
        return getOrders(name).take(limit);
    }
}

